package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.ProductDao;
import dao.ReviewDao;
import dao.likesDao;
import front.Handle;
import vo.MemberVo;
import vo.ProductVo;
import vo.ReviewVo;

public class ProductDataController implements Handle {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pno = Integer.parseInt(request.getParameter("pno"));
	      ProductDao dao = ProductDao.getInstance();
	      likesDao ldao = likesDao.getInstance();
	      int result=0;
	      ProductVo vo = new ProductVo();
	      vo = dao.selectProduct(pno);
	      vo.setPhotofiles(vo.getPhotofile().split(","));
	      
	      MemberVo membervo = (MemberVo)request.getSession().getAttribute("user");
	      ReviewDao rdao = ReviewDao.getInstence();
	      System.out.println("****************8"+membervo.getId()+"////////"+pno);
	      List<ReviewVo> list = rdao.showReview(pno);
	      System.out.println(list);
	      MemberDao mdao = MemberDao.getInstance();
	      for (int i = 0; i < list.size(); i++) {
	         if(list.get(i).getRphoto() != null) 
	           vo.setPhotofiles(vo.getPhotofile().split(","));
	      		if(list.get(i).getMid().length()<5) {
	      		 	list.get(i).setMid(mdao.changeId(list.get(i).getMid(), 1));
	      		}else {
	      			list.get(i).setMid(mdao.changeId(list.get(i).getMid(), 2));
	      		}
	      } if(membervo.getId()!=null) {
			 result = ldao.heart(membervo.getId(), pno);
	      }
			System.out.println("**************************"+result);
			System.out.println("hcount = " + result);
		request.setAttribute("hcount", result);
	      request.setAttribute("vo", vo);
	      request.setAttribute("review", list);
	      RequestDispatcher dispatcher = request.getRequestDispatcher("detail.jsp");
	      dispatcher.forward(request, response);
	}

}
