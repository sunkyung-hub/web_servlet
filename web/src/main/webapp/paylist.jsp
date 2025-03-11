<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String object = (String)request.getAttribute("object");
	String total = (String)request.getAttribute("total");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매확정 물품</title>
</head>
<body>
<form id="frm" method="post" action="./payok.do">
<p>구매확정 물품</p>

<%=object %>

<p>최종 결제금액: <%=total %> </p>

<input type="radio" name="a">신용카드<br>
<input type="radio" name="a">가상계좌<br>
<input type="radio" name="a">휴대폰 결제<br>
<input type="radio" name="a">무통장 입금<br>

<input type="button" value="결제진행" onclick="pay_go()">
</form>
</body>
<script>

function pay_go(){
	frm.submit();
}
</script>
</html>