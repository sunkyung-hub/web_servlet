function memberok(){
	if(frm.sid.value == ""){
		alert("아이디를 입력 후 중복체크를 하세요!");
	}
	else if(frm.spw.value == ""){
		alert("패스워드를 입력하세요");
	}
	else if(frm.snm.value == ""){
		alert("이름 및 회사명을 입력하세요");
	}
	else if(frm.stel.value == ""){
		alert("휴대폰 및 연락처를 입력하세요");
	}
	else if(frm.semail.value == ""){
		alert("이메일을 입력하세요");
	}
	else{
		if(frm.spart[0].checked == true){ //일반회원
			if(document.getElementById("idck").value == ""){
				alert("아이디 중복 체크를 해야만 회원가입이 진행됩니다.");
			}
			else{
				frm.submit();
			}
		}
		else{ //사업자회원
			if(frm.sno.value == ""){
				alert("사업자 번호를 입력하셔야 합니다.");
			}
			else if(frm.sno.value < 10){
				alert("올바른 사용자 번호를 입력하세요.");
			}
			else{
				frm.submit();
			}
		}
	}
}

function frm_view(part){
	var sp = document.getElementById("corp");
	
	//style.display: 해당 오브젝트를 웹에 출력 또는 미출력
	if(part=="C"){
		sp.style.display = "block";
	}
	else{
		sp.style.display="none";
	}
}

//아이디 중복체크 사항
function idcheck(){
	if(frm.sid.value==""){
		alert("아이디를 입력하셔야 합니다.");
	}
	else{
		//Ajax역할(Back-end 통신)
		ajaxpost(frm.sid.value);
	}
}

//Ajax 함수를 이용하여 중복체크
var ok = ""; //Back에게 통신을 보내는 역할하는 변수
function ajaxpost(data){
	//console.log(data); 
	function wck(){
		//window.XMLHttpRequest: 현재 웹페이지에서 XHR 통신을 사용함
		if(window.XMLHttpRequest){ //XHR 통신
			return new XMLHttpRequest(); //신규 XHR 통신을 생성
		}
	}

	function getdata(){
		/*
		XMLHttpRequest.UNSENT(0) = 객체를 생성(new XMLHttpRerquest())
		XMLHttpReuqest.OPENED(1) = XHR 통신 연결(open())
		XMLHttpReuqest.HEADERS_RECEIVED(2) = Back-end URL 및 통신규격(POST, GET 중 어떤것인지 핸들링)
		XMLHttpReuqest.LOADING(3) = Back-end 경로 응답 대기 시간 
		XMLHttpReuqest.DONE(4) = Back-end가 요청된 데이터 처리 완료 결과값을 보낸 경우 
		
		status: 통신에 대한 결과 코드 번호(200: 성공, 405: back-end쪽 문제사항, 404: URL경로 오류)
		*/
		//console.log(ok.readyState); //console에 1, 2, 3, 4찍힘 
		if(ok.readyState == XMLHttpRequest.DONE && ok.status==200){
			//console.log(this.response); //Back-end 결과값을 받음 // c, p 뜸
			
			if(this.response == "ok"){
				alert("사용가능한 아이디 입니다.");	
				document.getElementById("idck").value = "ok";
				frm.sid.readOnly = true;
				}
			else if(this.response == "no"){
				alert("해당 아이디는 이미 사용중입니다.");
				frm.sid.value = "";
			}	
		}
		}	
	//순서에 맞게 통신을 실행하는 역할
	ok = wck(); //신규 XHR 생성 
	ok.onreadystatechange = getdata; //해당 함수 결과를 받는 설정
	
	//Ajax 통신 규약 : POST, GET, PUT, DELETE
	//true: 비동기 통신, false: 동기통신
	//async: 비동기 통신, sync: 동기통신
	//비동기통신: 여러 데이터를 지속적으로 전송할 수 있으며, 결과값을 따로 받을 수 있음
	//동기통신: 순차적으로 처리하는 방식, 1:1. 결과가 날아와야 무조건 다음 순서를 진행 가능 / 동시다발적으로 진행시 오류 날 수도 있음
		//=>동기통신
	ok.open("GET", "./idcheck.do?sid="+data, true); //값을 이관(Back-end)
	//웹사이트의 network에 get -> 200, post -> 405가 뜸
	ok.send(); //Ajax 통신 실행
}

