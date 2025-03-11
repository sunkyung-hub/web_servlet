<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 정보 입력</title>
</head>
<body>
회원가입 정보 입력[간편가입] <br>
<form id="frm" method="post" action="http://172.30.1.4:8080/web/agreeok2.do">
<div>
아이디 <input type="text" name="id"> <br>
고객명 <input type="text" name="user"> <br>
비밀번호 <input type="text" name="password"> <br>
이메일 <input type="text" name="email"> <br>
휴대폰 번호 <input type="text" name="phone" maxlength="11"> <br>
이미지 <input type="text" name="image">

<button type="button" onclick="upload()">파일첨부</button> <br>
<button type="button" onclick="join2()">가입완료</button>
</div>
</form>
</body>
<script>
function join2(){
	frm.submit();
}
</script>
</html>
