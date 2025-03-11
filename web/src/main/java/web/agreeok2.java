package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class agreeok2 extends HttpServlet {
	
	PrintWriter pw = null;
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); //웹에서 html로 가상화 시킴
		
		try {
			this.pw = response.getWriter();
			
			String id = request.getParameter("id");
			String user = request.getParameter("user");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String image = request.getParameter("image");
			
			request.setAttribute("id", id);
			request.setAttribute("user", user);
			request.setAttribute("email", email);
			request.setAttribute("phone", phone);
			
	
			String url = "agreeok2.jsp"; //결과를 View(jsp)에 전달할 변수 값
			//RequestDispatcher: View를 선언하여 웹페이지에 출력되도록 설정
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}
		catch(Exception e) {
			this.pw.write("<script>"
					+ "alert('올바른 값이 전달되지 않았습니다.');"
					+ "history.go(-1);" //현재페이지의 이전페이지
					+ "</script>");
		}
	}

}
