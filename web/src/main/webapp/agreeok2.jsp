<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)request.getAttribute("id");
	String user = (String)request.getAttribute("user");
	String email = (String)request.getAttribute("email");
	String phone = (String)request.getAttribute("phone");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
</head>
<form id="frm" method="post">
<body>
아이디: <%=id%> <br>
고객명: <%=user%> <br>
이메일: <%=email%> <br>
휴대폰 번호: <%=phone%> <br>
</form>
</body>
</html>