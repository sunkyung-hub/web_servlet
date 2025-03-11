package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class paylist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//회원가입 완료
		PrintWriter pw = null;
		String url = null; //웹 경로를 저장하는 변수
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		try {
			this.pw = response.getWriter();
			String object = request.getParameter("selectedProducts");
			String total = request.getParameter("total");

			request.setAttribute("object", object);
			request.setAttribute("total", total);
			
			RequestDispatcher rd = request.getRequestDispatcher("./paylist.jsp");
			rd.forward(request, response);
		}
		catch(Exception e) {
			this.pw.write("<script>"
					+ "alert('올바른 데이터 접근이 아닙니다.');" //데이터가 제대로 넘어오지 않음
					+ "history.go(-1);"
					+ "</script>");
		}
		
		
	}

}
