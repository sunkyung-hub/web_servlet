package review;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class noticeok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PrintWriter pw = null; 
//	HttpServletRequest: 데이터 전달 통신 규격 interface
//	HttpServletResponse: 결과에 대한 응답 통신 규격 interface
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		try {
			
			this.pw = res.getWriter();
			String se = req.getParameter("se");
			if(se.equals("korea.com")){
				
				//web에서 값 받아옴
				String subject = req.getParameter("subject");
				String writer = req.getParameter("writer");
				String wtext = req.getParameter("wtext");
				
				
				//jsp로 값 보내줌
				req.setAttribute("subject", subject);
				req.setAttribute("writer", writer);
				req.setAttribute("wtext", wtext);
				
				// ./noticeview.jsp: 현재 위치(rewview)의 noticeview로 기억하지만,
				// .없이 /로 시작하면 현재 디렉토리가 아닌 webapp에서부터 시작
				RequestDispatcher rd = req.getRequestDispatcher("./noticeview.jsp");
				rd.forward(req,  res);
			}
			else {
				this.pw.write("<script>"
						+ "alert('올바른 접근 방법이 아닙니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}
		}
		catch(Exception e) {
			
		}
		finally {
			
		}
	}

}
