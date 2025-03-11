package review;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig( //첨부파일 환경설정
		fileSizeThreshold = 1024 * 1024 * 5, //한 개의 파일 전송크기: 5MB
		maxFileSize = 1024 * 1024 * 5, //파일 최대 크기 용량: 5MB
		maxRequestSize = 1024* 1024 * 100 //여러개의 첨부파일 업로드 시, 전체의 용량: 100MB 
)

public class io_ok extends HttpServlet {

	PrintWriter pw = null;
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		try {
			this.pw = response.getWriter();
			
			Part mfile = request.getPart("mfile");
			
		}
		catch(Exception e) {
			
		}
		finally {
			this.pw.close();
		}
		
	}

}
