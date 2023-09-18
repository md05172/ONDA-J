package controller;

/*
프로젝트 팀명:ONDA-J(온다잠)
작성자: 김종훈(팀장)
*/
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import dao.MemberDao;
import front.Handle;
import vo.MemberVo;

//회원 탈퇴
public class MemberDeleteController implements Handle {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVo vo= (MemberVo) session.getAttribute("user");
		int result = 0;
		
		MemberDao dao = MemberDao.getInstance();
		
		if(vo.getId() != null) 
		result = dao.delete(vo.getId());
		session.invalidate();
		RequestDispatcher dispatcher = request.getRequestDispatcher("../index.jsp");
		dispatcher.forward(request, response);
		
	}

}
