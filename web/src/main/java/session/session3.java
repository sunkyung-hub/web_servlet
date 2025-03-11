package session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class session3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession(); //무조건 선언
		//se.invalidate(); //(값 초기화) 모든 세션의 값을 초기화(삭제) = 로그아웃
		
		se.removeAttribute("tel"); 
		/*로그인 -> session2.do -> 로그아웃 -> session2.do 확인 시, tel만 삭제됨
		 *removeAttribute: 특정 세션값만 삭제를 할 수 있음*/
	}



}
