function partcheck(){
	//alert("test");
	var snoview = document.getElementById("snowview");
	if(part=="P"){
		snoview.style.display = "none";
	}
	else{
		snoview.style.display = "block";	
	}
}

function loginck(){
	if(frm.sid.value==""){
		alert("아이디를 입력하세요");
		return false; //submit이기 때문에 return false를 꼭 넣어줘야 함
	}
	else if(frm.spw.value==""){
		alert("패스워드를 입력하세요");
		return false;
	}
	else{
		//radio의 같은 name값이 두개이기 때문에 번호를 넣어줌
		if(frm.spart[0].checked == true){ //일반회원 체크
			//frm.submit();
			return true;
		}
	 	else if(frm.spart[1].checked == true){ //사업회원 체크
			if(frm.sno.value == ""){
				alert("사업자 번호를 입력하세요");
				return false;
			}
			else if(frm.sno.value.length < 10){
				alert("올바른 사업자 번호를 입력하세요");
				return false;
			}
			else{
				return true;
			}
		}
	}
}