package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HttpServlet: java를 웹에서 사용할 수 있도록 처리하는 클래스
public class login extends HttpServlet {
	
	//serialVersionUID: Backend 가상의 페이지 일련번호 
	private static final long serialVersionUID = 1L;  
    	//doget, dopost: Front-end가 form 태그에 method를 설정한 사항과 동일한 정보를 처리하는 메소드
    	//request: Front-end에게 전달 받는 값
		//response: Back-end가 처리한 결과값을 출력하는 역할
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getParameter: front-end에서 전달되는 name 이름을 말함
		request.setCharacterEncoding("utf-8"); //받는것도 utf-8, Front에서 한글일 경우 한글깨짐을 방지하는 언어셋
			
		//결과 내용을 한글 깨짐없이 사용하는 언어셋 세팅
		response.setCharacterEncoding("utf-8"); //응답하는것도 utf-8
		response.setContentType("text/html");
		
		String mid = request.getParameter("mid"); //scanner 역할
		String mpass = request.getParameter("mpass");
//		System.out.println(mid);
//		System.out.println(mpass);
		
		
		//PrintWriter: javascript를 핸들링. 
		PrintWriter pw = response.getWriter(); //현재 페이지에 받은 결과를 문자로 출력
		if(mid.equals("hong") && mpass.equals("a123456")) {
			pw.write("<script>"
					+ "alert('정상적으로 로그인 하셨습니다.');"
					+"</script>");
		}
		else {
			pw.write("<script>"
					+ "alert('아이디 및 패스워드를 다시 확인하세요');"
					+ "location.herf='./login.html';"
					+ "</script>");
		}
		
	}
		
}
