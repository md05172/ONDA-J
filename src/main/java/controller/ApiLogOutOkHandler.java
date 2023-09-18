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

import front.Handle;

//카카오 로그아웃
public class ApiLogOutOkHandler implements Handle {

   @Override
   public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  System.out.println("로그아웃 들어옴");
      HttpSession session = request.getSession();
      session.invalidate();
      RequestDispatcher dispatcher = request.getRequestDispatcher("/apiLogout.jsp");
      dispatcher.forward(request, response);
   }

}
