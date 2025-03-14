package mallpage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mallpage/product_list.do")
public class product_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//DTO
	dto_product pd = new dto_product(); //void 메소드일 경우 Controller가 가져가는 객체
	
	//select model
	m_product mp = new m_product();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//강제 형변환으로 오류 
		//Integer midx = Integer.parseInt(request.getParameter("midx"));
		
		//상품을 한가지를 클릭했을 경우 Front에서 Get 전송값
		String midx = request.getParameter("midx");
		String pagename = "";
		
		if(midx==null) { //값이 없을때
		ArrayList<ArrayList<String>> all = this.mp.product_all();
		request.setAttribute("all", all);
		
		
		//jsp 로드하여 View 역할로 데이터 출력
//		RequestDispatcher rd = request.getRequestDispatcher("./product_list.jsp");
//		rd.forward(request, response);
		pagename="./product_list.jsp";
		
		}
		else { //하나의 상품만 상세내역 
			this.pd.setMidx(Integer.parseInt(midx)); //DTO로 전달
			this.mp.oneproduct(this.pd); //DTO의 객체를 모델로 전달
			
			this.pd = this.mp.pd;
//			System.out.println(this.pd.getMidx());
			request.setAttribute("dto", this.pd);
			
			pagename="./product_view.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(pagename);
		rd.forward(request, response);
	}
}
