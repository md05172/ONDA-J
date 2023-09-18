package controller;

/*
프로젝트 팀명:ONDA-J(온다잠)
작성자: 김종훈(팀장)
*/
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.common.hash.Hashing;

import dao.MemberDao;
import front.Handle;
import vo.MemberVo;

//로그인
public class LoginActionController implements Handle {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("action들어옴");
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String url=null;
	    HttpSession session = request.getSession();
	      MemberDao dao = MemberDao.getInstance();
	      Map<String,String> map=new HashMap<String,String>();
	      map.put("id", id);
	      map.put("pw", pw);
	      if(dao.login(map)==1) {
	    	  System.out.println("성공");
	    	  MemberVo vo = dao.selectId(id);
	    	  url=request.getContextPath();
	      session.setAttribute("user", vo);
	      response.sendRedirect(url);
	      
	      }else {
	    	  url="fail.jsp";
	    	  response.sendRedirect(url);
	      }
		
	}

}
