package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class pollok extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	//method="get"
	//PrintWriter는 Controller에서 종료.(결과값에 대해서 처리) 
	//RequestDispatcher는 Controller에서 View(jsp)로 결과를 보내서 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); //front-end의 한글 깨짐 방지
		/* 교과서 버전
		response.setCharacterEncoding("utf-8"); //응답하는것도 utf-8
		response.setContentType("text/html");*/
		//실무 사용시
		response.setContentType("text/html;charset=utf-8");
		
		/*동일한 name 값으로 radio를 보냈을 때, radio는 여러 object 중 하나만 선택 가능
		/따라서 request.getParameter를 하나만 받아옴*/
		//getParameter: get, post(name 전달된 값 동일함)
		//request.getParameter: 무조건 front-end에서 값이 넘어와야 함 -> 넘어오지 않으면 무조건 오류
		//getParametersValues: 값을 여러개 받아올 때, values 씀
		String subject = request.getParameter("subject");	
		String etc[] = request.getParameterValues("etc"); //같은 이름을 가진 checkbox
//		ArrayList<String> etc = new ArrayList<String>(Arrays.asList(request.getParameterValues("etc")));
		/*	String subject = request.getParameter("subject").intern;
		-> .intern은 연산기호 사용 o, try-catch문 안에 넣지 않으면 오류 나면서 바로 정지*/
	
		PrintWriter pw = response.getWriter(); 
		
		//try-catch문을 사용했을 때는, RequestDispatcher와 PrintWriter를 같이 사용할 수 있음
		try {
			request.setAttribute("etc", etc);
			request.setAttribute("subject", subject);
			//request.setAttribute("", null);
			RequestDispatcher rd = request.getRequestDispatcher("./pollok.jsp");
			rd.forward(request, response);
		}
		catch(Exception e) {
			System.out.println(e);
			pw.write("<Script>"
			+"alert('올바른 접근이 아닙니다.');"
			+"</script>");
		}
		finally {
			pw.close(); //안닫아주면 계속 페이지 오픈 -> 메모리 잡아먹음
		}
		
		
	}

}
