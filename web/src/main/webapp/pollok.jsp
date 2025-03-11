<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String word = (String)request.getAttribute("abc"); //null, "" 출력
	//String word = request.getAttribute("abc").toString(); //"" 출력
	//String word = String.valueOf(request.getAttribute("abc")); //null, "" 출력
	out.print(word); 
	
	//작동 x
	//String etc = (String)request.getAttribute("etc");
	//String etc[] = 
	//out.print(etc);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사 결과값</title>
</head>
<body>

선택하신 과목: <%=word %>
배우고 싶은 과목: <%

int w=0;
//while(w<etc.length){ //Controller에서 원시배열로 값을 이관 받은 데이터를 반복문으로 View처리 
//	out.print(etc[w]+ ", ");
//	w++;
//}
%>

</body>
</html>