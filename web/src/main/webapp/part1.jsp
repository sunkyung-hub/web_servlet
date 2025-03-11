<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입[약관동의]</title>
</head>
<body>
<form id="frm" method="get" action="./part2.do">
<p>회원가입 약관</p>

<!-- value로 체크가 되었는지 안되었는지 확인 -->
<input type="checkbox" id="all" onclick="all_check(this.checked)"> 전체선택 <br>
<!-- all_checked(this.checked) -> all이 체크가 되었는지 아닌지 확인
     ag_check(): 하나라도 체크 해제시, 전체 선택의 체크박스가 해제되도록 하기 위함-->
<input type="checkbox" name="agree" value="Y0" onclick="ag_check()"> 서비스 이용약관 동의(필수) <br>
<input type="checkbox" name="agree" value="Y1" onclick="ag_check()"> 개인정보 수입 및 이용(필수)<br>
<input type="checkbox" name="agree" value="Y2" onclick="ag_check()"> 이메일 정보 수신 약관(필수) <br>
<input type="checkbox" name="agree" value="Y3" onclick="ag_check()"> 광고성 정보 수신(선택) <br>
<input type="button" value="회원가입" onclick="go_page()">

</form>
</body>
<script>
function go_page(){ //par2.do 전송
	//필수 약관이 체크되었을때 넘어가도록 확인
	
	if(frm.agree[0].checked==true && frm.agree[1].checked==true && frm.agree[2].checked==true){
		frm.submit();
	}
	else{
		alert("필수 조건은 무조건 동의 하셔야만 회원가입이 진행 됩니다.")
	}
}

var all_check = function(z){
	//console.log(z); // 전체선택 check하면 true, 체크하지 않으면 false뜸
	//조건문을 사용해도, 반복문을 사용해도 됨

	var ob = frm.agree; //form 태그 안에서 agree라는 name명을 가진 오브젝트 전체를 말함
	//console.log(ob); //RadioNodeList(4) [input, input, input, input, value: '']	
	var ea = ob.length;  //같은 이름의 name값은 배열로 순차적으로 처리됨.
	//console.log(ea); //4
	
	var w=0;
	do{
		ob[w].checked = z; //따라서 반복문에서 ob를 배열처리하여 ob[w]로 반복문 실행, 전체선택되도록함
		w++;
	}while(w<ea);
}

//하나라도 false일 경우, 전체 선택을 해제
//모두 체크가 되었을 경우 전체 선택이 체크됨
var ag_check = function(){ 
	var ob = frm.agree;
	var ea = ob.length;
	
	var w=0;
	var count=0;
	
	while(w<ea){
		if(ob[w].checked == true){ //반복문이 실행되었을 때 check가 되었으면
			count++; 
		}
		w++;
	}

	if(ea == count){
		document.getElementById("all").checked = true;
	}
	else{
		document.getElementById("all").checked = false;
	}
}
</script>


</html>