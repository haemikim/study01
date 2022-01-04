<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/HuggiesCss/header.css">
<meta charset="UTF-8">
<title>header</title>

   <header id="header">
            <div class="header_in">
                <h1 class="logo"><a href="index.html">하기스로고</a></h1>
                <nav class="gnb">
                    <ul>
                        <li><a href="#">브랜드스토리</a></li>
                        <li><a href="#">제품별리스트</a></li>
                        <li><a href="#">이벤트</a></li>
                        <li><a href="board_list.html">고객지원 </a></li>
                    </ul>
                </nav>
                <div class="util">
                    <ul>
                        <li class="login"><a href="login.html">로그인</a></li>
                        <li class="cart">
                            <a href="#">장바구니</a>
                            <span class="count">0</span>
                        </li>
                    </ul>
                </div>
            </div> <!-- .header_in -->
        </header> <!-- #header -->
