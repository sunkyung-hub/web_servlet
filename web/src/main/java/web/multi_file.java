package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//여러개의 파일을 전송하는 방식
//cos 사용없이 자체 라이브러리를 이용하여 설정
@MultipartConfig( //첨부파일 환경설정
		fileSizeThreshold = 1024 * 1024 * 2, //한 개의 파일 전송크기: 2MB
		//maxFileSize = 1024 * 1024 * 5, //파일 최대 크기 용량: 5MB
		//masFile을 무조건 사용하지 않아도 됨 - 조건에 맞게 사용
		//해당 max파일 용량이 5MB이상 될 경우 Server Down이 되어버림
		maxRequestSize = 1024* 1024 * 100 //여러개의 첨부파일 업로드 시, 전체의 용량: 100MB 
)
//조건문이 걸려있지 않기 때문에, Config에서 선언된 용량보다 큰 용량이 들어온다면
//서버가 그대로 죽어버림

public class multi_file extends HttpServlet {
	
	PrintWriter pw = null;
	
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.pw = response.getWriter();
			
			String mname = request.getParameter("mname"); 
			System.out.println(mname);
			/*Collection<Part> p = request.getParts(); 때문에 catch로 빠짐
			mfile뿐 아니라, mname까지 인식함 */
			
			String url = request.getServletContext().getRealPath("/upload/");
			//name을 따로 설정하지 않으며, 배열 클래스를 이용하여 IO값을 핸들링함
			//Collection: 모든 name값을 다 받을 수 있는 multi 파일
			Collection<Part> p = request.getParts();
			
			for(Part f : p) {
				long size = f.getSize(); 
				String filename = f.getSubmittedFileName(); //파일명을 가져오려고 함(모든 name을 파일로 가져오려고 함)
				//따라서 사용자가 직접 입력하는 것도 file로 가져오려고 하므로 오류 발생
				
				
				//조건문 연산기호로 핸들링. 
//				System.out.println(f.getSubmittedFileName());
				//if(!filename.equals("") && size < 2097152) { //파일명이 있을 경우, 2MB보다 작을 경우 저장, 오류
					
				//if(filename != null || size < 2097152) { //파일명이 null이 아니고, 2MB보다 작은 것 -> 오류 x
				
				//if(!filename.equals(null) && /*||*/ size < 2097152) { //오류
					
				/* equals 사용하면 안됨 !!!!!!!!!!! / equals와 ==는 다른 결과가 나타남 
				&&일때: 고객명을 null로 받고, size도 2MB이하이므로 조건 충족 -> 저장됨
				따라서 upload 디렉토리에 null로 저장됨
				||일때: 파일은 저장이 되지만, null도 같이 저장됨. -> f.write가 실행되기 때문
				   
				   따라서 파일명이 null이 아니고, size가 2MB가 아닐때로 조건 변경
				   filename == null && size < 2097152 --> filename != null && size < 2097152
					= null도 저장이 되지 않고, 고객명도 출력됨 -> 파일은 파일대로, 문자는 문자대로 핸들링 됨 */
				if(filename != null && size < 2097152) { //오류 x
					f.write(url + filename); //해당 조건이 맞을 경우 저장
				}
			}
		}
		catch(Exception e) {
			System.out.println(e);
			this.pw.write("<script>"
						+ "alert('올바른 접근 방법이 아닙니다.');"
						+ "history.go(-1);"
						+ "</script>");
		}
		finally {
			this.pw.close();
		}
	}

}
