package mallpage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shop.m_dbinfo;

//copyright model + login model
//model에서는 PrintWriter 사용 x
public class copyright {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null; 
	String sql = null;
	ArrayList<String> cp = null; 
	m_dbinfo db  = new m_dbinfo(); //DB 연결 파일
	String result = null;
	m_member mmb = new m_member(); //DTO 선언
	
	/*
    값 잘 가지고 왓는지 확인 시 조회용
   public static void main(String[] args) {
        new copyright().main2();
  }
   */

	//login 
	public String user_login(m_member dto) {
		try {
			this.con = this.db.getConnection();
			this.sql = "select mid, mname, memail from joins where mid=? and mpass=?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1,  dto.getMid());
			this.ps.setString(2,  dto.getMpass());
			this.rs = this.ps.executeQuery();
			if(this.rs.next() == true) { //정상적으로 아이디, 패스워드가 맞을 경우
				this.result = "ok";
				//기존에 사용된 DTO를 초기화 및 새로운 DTO값을 구성
				//m_member mb = new m_member();
				this.mmb.setMid(this.rs.getString("mid")); //아이디
				this.mmb.setMname(this.rs.getString("mname")); //가입자명
				this.mmb.setMemail(this.rs.getString("memail")); //이메일
				
				
			}
			else {
				
			}
		}
		catch(Exception e) {
			
		}
		finally {
			try {
			
				this.con.close();
			}
			catch(Exception e) {
				
			}
			finally {
				
			}
		}
		
		
		return this.result;
	}
	
	
	//copyright
	public ArrayList<String> copyright_info() {
		try {
			this.con = this.db.getConnection();
			//System.out.println(con); //메세지가 떠야만 db와 연결 된것(com.mysql.cj.jdbc.ConnectionImpl@2e385cce)
			this.sql = "Select * from corp_info";
			this.ps = this.con.prepareStatement(this.sql);
			this.rs = this.ps.executeQuery();
			//result를 넣어야 값을 읽을 수 있음 - buffered
			this.rs.next();
			this.cp = new ArrayList<String>();
			this.cp.add(this.rs.getString("corp_nm"));
			this.cp.add(this.rs.getString("ceo_nm"));
			this.cp.add(this.rs.getString("corp_add"));
			this.cp.add(this.rs.getString("corp_tel"));
			this.cp.add(this.rs.getString("corp_time"));
			this.cp.add(this.rs.getString("ceo_email"));
			this.cp.add(this.rs.getString("corp_no"));
			this.cp.add(this.rs.getString("corp_no2"));
			this.cp.add(this.rs.getString("corp_master"));
			this.cp.add(this.rs.getString("corp_domain"));
			System.out.println(this.cp); //출력이 잘 되는지 사실대로 확인
		}
		catch(Exception e) {
			System.out.println("Database Error!!");
		}
		finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
			}
			catch(Exception e) {
				System.out.println("Database Error!!");
			}
		}
		return this.cp;
	}

}
