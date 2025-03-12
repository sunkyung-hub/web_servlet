function ajaxs(){ //전송 버튼 클릭시 이벤트 함수
	var mid = document.getElementById("mid"); //id값 가져옴
	var memail = document.getElementById("memail"); //id값 가져옴
	
	if(mid.value == ""){
		alert("아이디를 입력하세요");
	}
	else{ //ajax post 통신을 위한 함수호출
		this.ajax_post(mid.value, memail.value);
		//else에 직접 ajax를 핸들링하면 코드가 복잡해지기 때문
	}
}

//ajax post로 전송하는 함수
function ajax_post(mid, memail){ //
	//console.log(mid);
	
	var http, result; //http: back-end 통신, result: back-end 제공한 데이터
	http = new XMLHttpRequest();
	http.onreadystatechange = function(){
		if(http.readyState==4 && http.status==200){
			console.log(this.response);
		}
		//else{
		//	console.log("통신 오류 발생!!")
		//}
		else if(http.status==404){
			console.log("경로 오류발생!!");
		}
		else if(http.status==405){
			console.log("통신 규격 오류 발생!!");
		}
	}
	
	//get 통신
	/*http.open("get", "./ajax_postok.do?userid=", +mid, true);
	http.sned();
	*/
	
	//post 통신 
	http.open("post", "./ajax_postok.do", true); //비동기통신을 진행하겠다는 의미
	
	//ajax post 전송시 content-type 적용하여, urlencoded를 적용해야만 정상적으로 백엔드에게 값을 전송함
	http.setRequestHeader("content-type", "application/x-www-form-urlencoded");
	//http.send("userid=" +mid); //데이터 값을 한개 전송
	http.send("userid="+mid+"&usermail="+memail); //한개 이상부터 &사용
	
}