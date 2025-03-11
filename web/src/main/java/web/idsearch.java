package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//public class idsearch extends HttpServlet {
//	private static final long serialVersionUID = 1L;
// 
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html");
//		
//		PrintWriter pw = response.getWriter();
//		
//		try {
//			//front 값을 받는 역할
//			String user = request.getParameter("user");
//			String phone = request.getParameter("phone");
//			String email = request.getParameter("email");
//			String msg = "";
//			
//			//javascript 핸들링
//			if(user.equals("hong") && phone.equals("01010041919") && email.equals("hong@naver.com")) {
//				msg = "hong2025";
//			}
//			else {
//				msg = "가입정보가 확인되지 않습니다.";
//			}
//			
//			//Controller -> jsp로 전달
//			request.setAttribute("msg", msg);
//			
//			//해당 코드는 무조건 맨아래에 위치해야 함
//			RequestDispatcher rd = request.getRequestDispatcher("/idsearch.jsp");
//			rd.forward(request, response);
//		}
//		catch(Exception e) {
//			pw.write("<script>"
//					+ "alert('올바른 값이 전달되지 않았습니다.');"
//					+ "history.go(-1);" //현재페이지의 이전페이지
//					+ "</script>");
//		}
//	}
//}

//선생님 코드
public class idsearch extends HttpServlet {

	PrintWriter pw = null;
	
	private static final long serialVersionUID = 1L;
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); //웹에서 html로 가상화 시킴
		//java도 html처럼 출력하기 위해
		
		try {
			this.pw = response.getWriter();
			String mname = request.getParameter("mname");
			String mtel = request.getParameter("mtel");
			String memail = request.getParameter("memail");
			String result = ""; //결과를 View(jsp)에 전달할 변수 값
			
			if(mname.equals("hong") && mtel.equals("01010041919") && memail.equals("hong@naver.com")) {
				result = "hong2025";
			}
			else {
				result = "가입정보가 확인되지 않습니다.";
			}
			
			request.setAttribute("result", result); //결과값 jsp로 전달 
			RequestDispatcher rd = request.getRequestDispatcher("/idsearch.jsp");
			rd.forward(request, response);
	
		}
		catch(Exception e) {
			this.pw.write("<script>"
					+ "alert('올바른 값이 전달되지 않았습니다.');"
					+ "history.go(-1);" //현재페이지의 이전페이지
					+ "</script>");
		}
		finally {
			this.pw.close();
		}
		
	}
}
