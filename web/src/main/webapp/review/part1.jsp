<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰 등록 페이지</title>
</head>
<body>
<form id="frm" method="get" action="./part_2.do">
<p> 쿠폰 등록 페이지 </p>
아이디: <input type="text" name="mid"><br>
쿠폰번호: <input type="text" name="mco"><br>
<input type="checkbox" name="ch"> 광고 수신 동의(필수) <br>
<input type="button" value="예매하기" onclick="book()">
</form>
</body>
<script>

function book(){ //예매하기
	
	if(frm.mid.value == ""){
		alert("아이디를 입력하세요");
		frm.mid.focus();
	}
	else if(frm.mco.value == ""){
		alert("쿠폰번호를 입력하세요");
		frm.mco.focus();
	}
	else if(frm.ch.checked == false){
		alert("광고 수신 동의를 체크해주십시오.");
	}
	else{
		frm.submit();
	}
	
}
</script>

</html>