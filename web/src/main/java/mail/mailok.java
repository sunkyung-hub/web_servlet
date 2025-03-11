package mail;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.m_dbinfo;


public class mailok extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	Connection con = null; //DB연결(SQL Query문 실행)
	PrintWriter pw = null;
	PreparedStatement ps = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		this.pw = response.getWriter();
		m_dbinfo db = new m_dbinfo();
		
		try {
			this.con = db.getConnection();
			String to_name = request.getParameter("to_name");
			String to_mail = request.getParameter("to_mail");
			String subject = request.getParameter("subject");
			String context = request.getParameter("context");
			
			String sql = "";
			sql = "insert into mail (sidx, to_name, to_mail, subject, context, sdate)"
					+ "values('0', ?, ?, ?, ?, now())";
			this.ps = this.con.prepareStatement(sql);
			this.ps.setString(1, to_name);
			this.ps.setString(2, to_mail);
			this.ps.setString(3, subject);
			this.ps.setString(4, context);
			
			int result = this.ps.executeUpdate();
			 if(result > 0) {
				 this.pw.write("<script>"
				 		+ "alert('메일이 정상적으로 전송되었습니다.');"
				 		+ "location.href='./mailok.jsp';"
				 		+ "</script>");
			 	}
		}
		catch(Exception e) {
			System.out.println(e);
			this.pw.write("<script>"
			 		+ "alert('메일 전송을 실패하였습니다.');"
			 		+ "history.go(-1)"
			 		+ "</script>");
		}
		
	}

}
