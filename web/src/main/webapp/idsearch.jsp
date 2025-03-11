<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Controller에서 데이터 값을 이관하는 형태
	String msg = (String)request.getAttribute("msg");
	//String result = (String)request.getAttribute("result");	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 데이터</title>
</head>
<body>
아이디: <%=msg%>
</body>
</html>