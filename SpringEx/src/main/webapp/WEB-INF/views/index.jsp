<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="header.jsp" %> 
<!-- 고정되어 계속 나오는 부분을 링크로 걸어서 한개로 여러곳에 보이게 해놓음(gnb부분)-->
index.jsp파일입니다
<a href="/sample/member?id=abcd&pw=1234&name=정자바">회원가입</a>
<form action="/sample/memberDTO" method="post">
	<div>id:<input type="text" name="id" value="abcd"></div>
	<div>pw:<input type="password" name="pw" value="1234"></div>
	<div>name:<input type="text" name="name" value="정자바"></div>
	<inpute type="submit" value="회원가입">
</form>
</body>
</html>