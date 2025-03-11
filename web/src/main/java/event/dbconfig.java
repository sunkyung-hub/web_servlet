package event;
//db 환경설정 및 셋팅값

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconfig {
	public static Connection info() throws Exception{
		
//		String database = "com.mysql.jdbc.Driver"; //v5.1, v5.5일 때
		
//		mysql version에 연결 설정 파트
		String database = "com.mysql.cj.jdbc.Driver"; //v5.7이상
		
//		mysql 연결 경로
		String dburl = "jdbc:mysql://localhost:3306/mrp";
		String user = "project"; //mysql id
		String passwd = "p402402"; //mysql pw 
		
		//어떤 라이브러리를 이용하여 DB에 접속할것인지를 정함
		Class.forName(database);
		
		//= mysql -u 아이디 -p
		Connection con = DriverManager.getConnection(dburl, user, passwd);
		return con;		
	}
}
