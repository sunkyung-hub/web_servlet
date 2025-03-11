<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Controller에서 session을 받고 해당 session값을 문자열로 변환 후, html에 출력
	
	//(String), toString은 차이
	//값이 없을 시 (String)사용 시 값은 null로 바뀜, toString은 내부 서버 오류 발생
	HttpSession se = (HttpSession)request.getAttribute("se");
	String userid = (String)se.getAttribute("id");
	String usernm = (String)se.getAttribute("name");
	String usertel = (String)se.getAttribute("tel");
	
	//String userid = se.getAttribute("id").toString();
	//String usernm = se.getAttribute("name").toString();
	//String usertel = se.getAttribute("tel").toString();
	
	if(userid == null){ //getAttribute를 사용할때는 equals가 아닌 ==(연산기호) 사용해야 함
		//out.print는 한 줄로 작성해야 함
		out.print("<script>alert('로그인 하셔야 합니다.');location.href='./login.html'</script>");
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 정보 출력</title>
</head>
<body>
<%=usernm%>님 환영합니다. <input type="button" value="로그아웃" onclick="logout()"><br>
아이디: <%=userid%><br>
연락처: <%=usertel%><br>

</body>

<script>

function logout(){
	if(confirm("로그아웃 하시겠습니까?")){
		location.href="./session3.do";
	}
}
</script>
</html>