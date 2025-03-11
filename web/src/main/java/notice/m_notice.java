package notice;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import shop.m_dbinfo;
import shop.m_md5;

//공지사항 게시판 파일을 저장하는 Model
public class m_notice {
	
	Connection con = null;
	PreparedStatement ps = null;
	
	//Model
	m_dbinfo db = new m_dbinfo(); //DB접속정보
	m_md5 md5 = new m_md5(); //md5암호화
	
	String sql = ""; //DB Query문 
	int result = 0; //DB저장 결과값
	
	String msg = ""; //Model에서 처리된 값을 컨트롤러로 반환하는 변수
	
	String subject,writer,pw,texts;
	
	
	//즉시 실행 메소드에서는 첨부파일을 저장하는 역할만 진행 
	public m_notice(Part nfile, String subject, String writer, String pw, String texts, HttpServletRequest request) throws Exception { //즉시실행
		this.subject = subject;
		this.writer = writer;
		this.pw = pw;
		this.texts = texts;
		
		long filesize = nfile.getSize(); //파일용량
	
		//파일명
		//String filenm = nfile.getName(); //getName(): 자료형
		String filenm = nfile.getSubmittedFileName(); //파일명이 찍힘
		
		System.out.println(filenm); 
		//getName: nfile 출력 - html코드의 name 
		//getSubmittedFileName: cms.sql 출력 - 파일명 그대로 출력
		
		//첨부파일 저장될 Web 디렉토리 설정
		//System.out.println(request.getServletContext().getRealPath(""));
		/*cat.jpeg
		D:\web_servlet\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\web\*/
		
		String url = request.getServletContext().getRealPath("/notice_file/");
		//notice_file안에 저장하겠다 선언
		
		try {
			nfile.write(url + filenm); //웹에 저장
			this.fileok(filenm); //정상적으로 저장되었을 경우
		}
		catch(Exception e) {
			this.fileok("error"); //비정상적으로 해당 디렉토리에 파일이 저장되지 않을경우
		}
	}
	/*
	 * 만약 finally에 try-catch를 진행하지 않고,private String fileok(String data) throws Exception을 하면
	 * 위의 this.fileok("error")에 오류 발생 -> public m_notice에 throws Exception 넣어주어야 함
	 *  */
	
	//DB로 저장 및 Controller로 결과값을 return 하는 메소드
	private String fileok(String data) throws Exception {
		if(data.equals("error")) {
			this.msg = "error";
		}
		else { //파일 정상적으로 저장 되었을 경우
			try{
				//물음표 갯수와 setString갯수를 맞춰서 잘 넣어야 함 -> 넣지 않으면 오류발생
				this.con = this.db.getConnection();
				this.sql = "insert into notice (nidx,subject,writer,pw,texts,filenm,nfile,ndate)"
						+ "values ('0', ?, ?, ?, ?, ?, ?, now())";
				this.ps = this.con.prepareStatement(this.sql);
				this.ps.setString(1, this.subject);
				this.ps.setString(2, this.writer);
				this.ps.setString(3, this.pw);
				this.ps.setString(4, this.texts);
				this.ps.setString(5, data); //data가 file명
				this.ps.setString(6, data);
				this.result = this.ps.executeUpdate();
				
				if(this.result > 0) {
					this.msg = "ok";
				}
			}
			catch(Exception e) {
				this.msg = "error";
			}
			finally {
					this.ps.close();
					this.con.close();
			}
		}
		return this.msg; //Controller로 보내는 값
	}
}
