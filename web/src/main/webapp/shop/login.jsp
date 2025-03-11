<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//out.print 적용했을 때 null 출력이 될 경우(session) -> 연산기호
	HttpSession hs = request.getSession();
	String mid = (String)hs.getAttribute("mid");
	String mnm = (String)hs.getAttribute("mnm");
	
	if(mid != null || mnm != null){ //로그인이 되어 있을 경우, 다시 로그인하지 못하도록 처리
		out.println("<script>"
				+ "alert('이미 로그인 하셨습니다.');"
				+ "location.href='./main.jsp';"
				+ "</script>");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 로그인</title>
</head>
<form id="frm" method="post" action="./shop_loginok.do" onsubmit="return loginck()">
<body>
<p>[회원 로그인]</p>

<!-- label: 글자 클릭해도 선택됨 / onclick을 넣으면, label을 넣은 의미 x -> 글자 눌렀을 때 선택안됨
label에 onclick을 넣으면 더블 핸들링이 일어남 / input 안에 넣으면서, this.value를 넣어줌 -->
<label>
<input type="radio" name="spart" value="P" onclick="partcheck(this.value)" checked="checked"> 일반회원
</label>
<label>
<input type="radio" name="spart" value="C" onclick="partcheck(this.value)"> 사업자회원
</label>
<br>
<input type="text" name="sid" placeholder="아이디를 입력하세요"><br>
<input type="text" name="sid" placeholder="패스워드를 입력하세요"><br>
<span id="snoview" style="display:none">
<input type="text" name="sno" placeholder="사업자 등록번호"><br>
</span>
<input type="submit" value="로그인">
</body>
</form>
</html>