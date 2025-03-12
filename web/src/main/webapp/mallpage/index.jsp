<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String test = "홍길동";
%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>Shop Bag</title>
    <meta charset="utf-8" />
    <link href="./index.css" rel="stylesheet" />
    <link href="./menu.css?v=1" rel="stylesheet"/>
  </head>

  <body>
  <!-- 상단 로고 및 메뉴 -->
  <!-- header 코드를 지우고, top.jsp를 새로 만들어
  top.jsp에 header코드를 집어넣고 @include file로 연결 -->
 <%--jsp 주석--%>
<%@include file="./top.jsp" %>
<!-- 상단 로고 & 메뉴 -->

 <main>
 <!-- 배너 --> 
    <%@include file="./banner.jsp" %>
 <!-- 배너 -->
 <!-- 신상품 -->
    <%@include file="./product.jsp" %>
<!-- 신상품 -->
</main>
<!-- 카피라이터 및 하단 -->
<footer>
   <%@include file="./footer.jsp" %>
</footer>
<!-- 카피라이터 및 하단 -->
  </body>
</html>