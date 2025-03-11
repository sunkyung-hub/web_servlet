package session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class session2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession();
		
		
		//getAttribute: 세션에 저장된 값을 가져올 때, get을 이용하여 처리할 수 있음
//		System.out.println(se.getAttribute("id")); //hong
//		System.out.println(se.getAttribute("name")); //홍길동
//		System.out.println(se.getAttribute("tel")); //01012341004
		
		
		request.setAttribute("se", se); //jsp로 session을 전달
		
		RequestDispatcher rd = request.getRequestDispatcher("./session2.jsp");
		rd.forward(request, response);
		
		//getMaxInactiveInterval(): 세션 최대 유지시간을 확인하는 클래스
		//해당 시간이 지나면 브라우저에서 정보를 자동으로 삭제 해버림 -> 보안을 위해
		System.out.println(se.getMaxInactiveInterval()); //1800 -> 세션 유지 시간
	}

}
