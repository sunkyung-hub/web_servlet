/**
 * 
 */

function notice_write(){
	
	if(frm.subject.value==""){ //제목 name: subject
		alert("제목을 입력하세요");
	}
	else if(frm.writer.value==""){ //글쓴이 name: wirte
		alert("글쓴이를 입력하세요");
	}
	else if(frm.wtext.value==""){ //내용 name: wtext
		alert("내용을 입력하세요");
	}
	else{
		frm.submit(); //post로 전송 됨
	}
}