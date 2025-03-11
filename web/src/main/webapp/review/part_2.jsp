<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mid = (String)request.getAttribute("mid");
	String mco = (String)request.getAttribute("mco");
	String result = (String)request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰 등록 완료 페이지</title>
</head>
<body>

<p>쿠폰 등록 완료 페이지</p>
아이디: <%=mid %><br>
쿠폰번호: <%=mco %><br>

광고 수신 동의함 

</body>
</html>