//m_noticelist.java

package notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shop.m_dbinfo;

//DB에 있는 모든 데이터를 가져오는 역할
public class m_noticelist {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String sql; //SQL Query
	ArrayList<String> data = null;
	ArrayList<ArrayList<String>> alldata = null;
	
	 //Model
    m_dbinfo db = new m_dbinfo(); //DB접속정보
    
	public m_noticelist(){
		
	}
	
	public ArrayList<ArrayList<String>> db_data(){
		
		try {
			this.con = db.getConnection();
			this.sql = "select nidx,subject,writer,nview,ndate from notice order by nidx desc";
			this.ps = this.con.prepareStatement(this.sql);
			this.rs = this.ps.executeQuery(); //select
			this.alldata = new ArrayList<ArrayList<String>>();
			while(this.rs.next()) {
				//1차 배열에 데이터 추가
				this.data = new ArrayList<String>();
				this.data.add(this.rs.getString("nidx"));
				this.data.add(this.rs.getString("subject"));
				this.data.add(this.rs.getString("writer"));
				this.data.add(this.rs.getString("nview"));
				this.data.add(this.rs.getString("ndate"));
				
				//1차 배열에 저장된 값을 2차 배열에 집어넣음
				this.alldata.add(this.data);
				
			}
			//System.out.println(this.alldata);
		}
		catch(Exception e) {
			this.alldata = null; //데이터가 null로 빠짐 -> 잘못 작성
		}
		finally {
			try {
				this.ps.close();
				this.con.close();
			}
			catch(Exception e) {
				
			}
		}
		//Model에서 컨트롤러로 데이터를 회신함
		return this.alldata;
	}
}
