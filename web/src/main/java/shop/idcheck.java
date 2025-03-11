package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class idcheck extends HttpServlet {
	
	Connection con = null;
	
	private static final long serialVersionUID = 1L;
    
	//ajax 통신을 받는 메소드(아이디 중복체크)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String msg =""; //Front-end에게 결과값을 보내는 변수명
		
//		//ajax로 front가 보낸 데이터를 받는 역할
//		String id = request.getParameter("sid");
		
		//Back이 front에게 결과값을 통보하는 역할
		PrintWriter pw = response.getWriter();
		try {
			//ajax로 front가 보낸 데이터를 받는 역할
			String id = request.getParameter("sid");
			
			if(id.equals("")) {
				//System.out.println("아이디 없음");
				msg = "error";
			}
			else {
				m_dbinfo db = new m_dbinfo();
				this.con = db.getConnection(); //DB 연결시작
				/*sql query문 작성방법
				1. select -> ResultSet, executeQuery
				2. insert, update, delete -> int, executeUpdate
				*/
				String sql = "select count1(*) from shop_member where sid='"+id+"'";
				Statement st = this.con.createStatement();
				/*Statement: Database에 쿼리문을 작성할 수 있도록 사용하는 메소드
				  createStatement(): create, alter, drop */
				ResultSet rs = st.executeQuery(sql); //executeQuery: select에만 사용하는 명령어 / ResultSet: executeQuery 결과값을 받는 역할	
			
				if(rs.next() == true) { //정상적으로 쿼리문이 작동했을 경우
//					System.out.println(rs.getString("ctn")); //해당 데이터가 없을때
//					if(rs.getString("ctn")=="0") //연산기호는 넣으면 x, equals 넣어야 함. 연산기호는 intern과 같이 써야 함
					if(rs.getString("ctn").equals("0")){
						msg="ok";
					}
					else { //검색한 데이터가 있을 경우
						msg="no";
					}
				} 
				//close 되지 않으면 catch로 빠질 수도 있음
				rs.close();
				st.close();
				
				
//					else {
//					System.out.println("동일한 데이터가 없음");
//				}

				//반복문 사용했을 경우
//				while(rs.next()) { //rs.next(): 결과값에 대해서 반복문이 실행(true, false가 진행됨)
//					System.out.println(rs.getString("ctn"));
//				}
//				String id = request.getConnection;
			}
			pw.write(msg);
		}
		catch(NullPointerException ne) { //Front가 올바른 값을 전달하지 않았을 경우
			msg="error";
			pw.write(msg); 
		}
		catch(Exception e) {
//			msg = "DB error";
//			msg = "DBS error";
			msg = "mysql-code 844"; 
			pw.write(msg); //ok: 사용가능 아이디, no: 사용불가능 아이디, error: 데이터 오류
		}
		finally {
			pw.close();
		}
		
//		pw.write("ok"); //ok: 사용가능 아이디, no: 사용불가능 아이디, error: 데이터 오류
//		pw.close();
//		//System.out.println(id);
	}

}
