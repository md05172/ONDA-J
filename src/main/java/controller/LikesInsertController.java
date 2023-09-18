package controller;

/*
프로젝트 팀명:ONDA-J(온다잠)
작성자: 김종훈(팀장)
*/
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.likesDao;
import front.Handle;

//숙소 찜 하기
public class LikesInsertController implements Handle {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		likesDao dao = likesDao.getInstance();
		int pno = Integer.parseInt(request.getParameter("pno"));
		System.out.println("pno = " + pno);
		String mid = request.getParameter("mid");
		
			System.out.println(mid+"////"+pno);
		
		int cnt = dao.heart(mid, pno);
		if(cnt == 0) {
			dao.insert(mid, pno);
		}
		System.out.println(pno);
		System.out.println(mid	);
	}
}
