package review;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class part_2 extends HttpServlet {

	PrintWriter pw = null;
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); //한글이 날아오면 사용하기 위해 작성
		response.setContentType("text/html;charset=utf-8");
		
		try {
			this.pw = response.getWriter();
			//String arr[] = {"A1316B1004", "C4024A0096", "B1987C3136"};
			String mid = request.getParameter("mid");
			String mco = request.getParameter("mco");
//			String result = ""; 
			
			if(mco.equals("A1316B1004") || mco.equals("C4024A0096") || mco.equals("B1987C3136")) {
				System.out.println(mco);
				
			}
			else {
				this.pw.write("<script>"
						+ "alert('해당 쿠폰번호를 확인하세요');"
						+ "history.go(-1);" //현재페이지의 이전페이지
						+ "</script>");
				pw.flush();
				return; //실행중단
				
			}
//			request.setAttribute("result", result); //결과값s jsp로 전달 
			request.setAttribute("mid", mid); //결과값 jsp로 전달 
			request.setAttribute("mco", mco); //결과값 jsp로 전달 
			RequestDispatcher rd = request.getRequestDispatcher("./part_2.jsp");
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
