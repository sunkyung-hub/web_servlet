package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//session1 -> session을 생성하는 컨트롤러
/*
 * session: 일정시간 동안 브라우저에 해당 값을 저장 및 유지시키는 방식(back-end만 생성 가능)
 * cookie: 브라우저의 cache 메모리에 값을 저장하는 방식(도메인 및 ip 기준)(front, back-end 생성가능)
 * storage: 메모리에 저장(front, backend) -> local, session */
public class session1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	PrintWriter pw = null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String mid = request.getParameter("mid");
			String mpass = request.getParameter("mpass");
			response.setContentType("text/html;charset=utf-8");
			/* login.html에서 정상적으로 로그인시, session1.java실행 -> 브라우저에 저장이 됨
			 * session2.java를 강제로 실행시키게 되면, 브라우저에 저장된 값을 가져오면서 hong, 홍길동을 console에 출력시킴
			 * session3.java를 강제로 실행시키게 되면, 기존에 만들어놨던 세션을 초기화 시킴
			 * 따라서 session3.java 실행 후, 다시 session2.java를 실행시키면 null, null출력
			 * 
			 * 모든 웹페이지를 다 닫은 후, session2.java를 실행하면 null, null 출력
			 * 
			 * session: 로그인할 때 주로 사용하며, 로그아웃을 실행하지 않을 시 세션은 정보를 계속해서 기억하고 있음 (서로 다른 브라우저일때는 x)
			 * 사용자명, 이메일 등은 세션으로 만들어 놓지만, 패스워드는 세션으로 만들어 놓지 않음*/
			
			//정상적인 로그인 상황
			if(mid.equals("hong") && mpass.equals("a1234")) {
				String username = "홍길동";
				String usertel = "01012341004";
				
				//HttpSession: 브라우저의 cache 메모리에 데이터를 임시저장
				HttpSession se = request.getSession();
				
				//Session을 생성
				se.setAttribute("id", mid);
				se.setAttribute("name", username);
				se.setAttribute("tel", usertel);
			}
			else { //아이디 및 패스워드가 틀릴 경우
				this.pw.write("<script>"
						+ "alert('아이디 및 패스워드를 확인하세요');"
						+ "history.go(-1);"
						+ "</script>");
			}
	}

}
