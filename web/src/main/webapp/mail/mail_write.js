function send(){
	if(frm.to_name.value==""){
		alert("담당자 성함을 입력하세요.");
		frm.to_name.focus();
	}
	else if(frm.to_mail.value==""){
		alert("회신받을 메일주소를 입력하세요");
		frm.to_mail.focus();
	}
	else if(frm.subject.value==""){
		alert("제목을 입력해주세요.");
		frm.subject.focus();
	}
	else{
		if(frm.context.value == ""){
			alert("내용을 입력하셔야 합니다.");
		}
		else{
			frm.submit();
		}
		
	}
}