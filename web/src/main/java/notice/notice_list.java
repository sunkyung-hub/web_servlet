package notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class notice_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//list를 출력하기 위한 DB Table을 로드하는 Model
		m_noticelist nl = new m_noticelist();
		
		//2차 클래스 배열로 저장된 테이블에 모든 데이터를
		ArrayList<ArrayList<String>> result = nl.db_data();
		
		//System.out.println(result);
		
		request.setAttribute("result", result);
		
		//실행시킬 때 jsp가 아니라 do를 먼저 실행시키고 jsp를 실행시켜야 함
		//jsp를 먼저 실행시키면 오류 발생 할 수 있음
		RequestDispatcher rd = request.getRequestDispatcher("./notice_list.jsp");
		rd.forward(request, response);
	}

}
