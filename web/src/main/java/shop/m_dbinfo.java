package shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

//Database, 사용자 아이디, 사용자 패스워드 등록
public class m_dbinfo {
	 // Database의 기본 메소드명 : getConnection
	public static Connection getConnection() throws Exception{
		
		//해당 라이브러리를 가져오는 역할 변수
		String db_driver = "com.mysql.cj.jdbc.Driver";
		
		//DB 경로 연결: jdbc:mysql://ip or domain:port번호
		String db_url = "jdbc:mysql://localhost:3306/mrp";
		
		//mysql에 접속하는 사용자
		String db_user = "project";
		
		//mysql에 접속하는 사용자의 패스워드
		String db_passwd = "a12345";
		
		//실제 DB에 연결을 하는 명령어
		Class.forName(db_driver);
		Connection con = DriverManager.getConnection(db_url, db_user, db_passwd);
		//System.out.println(con);
		return con; //DB가 정상적으로 연결이 되었는지 확인 결과를 return함
				
	}

}
