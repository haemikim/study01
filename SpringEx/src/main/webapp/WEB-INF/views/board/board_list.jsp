<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/resources/HuggiesCss/board_list.css">
<meta charset="UTF-8">
<title>borderList</title>
</head>
<body>
<div id="wrap">
<%@ include file="header.jsp" %>

 <div id="board_contents">
            <div class="sub_title">
                <h1 class="st">
                    <a href="board_list.html">
                           고객 지원
                    </a>
                </h1>
            </div><!--sub_title-->

            <div class="bd_search">
                <div class="bd_ask">
                    <h2>무엇을 도와드릴까요?</h2>
                </div>
                <div class="bd_sh">
                    <form>
                        <fieldset class="bd_field">
                            <legend>검색</legend>
                            <input type="text" id="search_board" class="search_board" title="검색어" placeholder="궁금한 점이 있이면 검색해주세요.">
                            <button type="submit" class="btn_search">
                                <span class="sch_icon">검색</span>
                            </button>
                        </fieldset>
                    </form>
                </div>
            </div><!--bd_search-->
    
            <div class="board_main" >
            <div class="write">
                    <form action="board_list_write.html">
                        <button class="btn_write">
                             글쓰기
                        </button>
                    </form>
                </div>
                <table class="board_list">
                    <thead >
                        <tr class="table_title">
                            <th class="th_Category">카테고리</th>
                            <th class="article_title">제목</th>
                            <th class="th_name">작성자</th>
                            <th class="th_date">작성일</th>
                            <th class="th_view">조회</th>
                        </tr>
                    </thead>
                    <tbody class="bd_tbody">
                        <tr class="board_notice">
                            <th class="bd_notice">
                                <span>notice</span>
                            </th>
                            <th class="bd_title">
                                <a href="board_list_page.html">공지 사항</a>
                            </th>
                            <th class="bd_name">관리자</th>
                            <th class="bd_date">2021-22-25</th>
                            <th class="bd_view">19</th>
                        </tr>
                        <tr class="board_notice">
                            <th class="bd_notice">
                                <span>notice</span>
                            </th>
                            <th class="bd_title">
                                <a href="board_list_page.html">공지 사항</a>
                            </th>
                            <th class="bd_name">관리자</th>
                            <th class="bd_date">2021-22-25</th>
                            <th class="bd_view">19</th>
                        </tr>
                        <tr>
                            <th class="bd_Category">[주문/결제]</th>
                            <th class="bd_title">
                                <a href="#">이미 주문은 했는데 결제방법을 바꾸려면 어떻게 해야 하나요?</a>
                            </th>
                            <th class="bd_name">김이박</th>
                            <th class="bd_date">2021-22-25</th>
                            <th class="bd_view">19</th>
                        </tr>
                        <tr>
                            <th class="bd_Category">[주문/결제]</th>
                            <th class="bd_title">
                                <a href="#">전화로도 주문 할 수 있나요?</a>
                            </th>
                            <th class="bd_name">김이박</th>
                            <th class="bd_date">2021-22-25</th>
                            <th class="bd_view">19</th>
                        </tr>
                        <tr>
                            <th class="bd_Category">[주문/결제]</th>
                            <th class="bd_title">
                                <a href="#">금액 상관없이 할부가 가능한가요?</a>
                            </th>
                            <th class="bd_name">김이박</th>
                            <th class="bd_date">2021-22-25</th>
                            <th class="bd_view">19</th>
                        </tr>
                        <tr>
                            <th class="bd_Category">[배송]</th>
                            <th class="bd_title">
                                <a href="#">배송시간이 얼마나 걸리나요?</a>
                            </th>
                            <th class="bd_name">김이박</th>
                            <th class="bd_date">2021-22-25</th>
                            <th class="bd_view">19</th>
                        </tr>
    
                        <tr>
                            <th class="bd_Category">[환불/교환/반품]</th>
                            <th class="bd_title">
                                <a href="#">여러 개의 상품 중 일부만 반품하고 싶습니다.</a>
                            </th>
                            <th class="bd_name">김이박</th>
                            <th class="bd_date">2021-22-25</th>
                            <th class="bd_view">19</th>
                        </tr>
                        <tr>
                            <th class="bd_Category">[상품]</th>
                            <th class="bd_title">
                                <a href="#">매월 구매 가능한 기저귀 수량이 제한되어 있나요? (기저귀 상품별 구매 제한 ID 당 최대 7박스)</a>
                            </th>
                            <th class="bd_name">김이박</th>
                            <th class="bd_date">2021-22-25</th>
                            <th class="bd_view">19</th>
                        </tr>
                    </tbody>
                </table>
            </div><!--board_main--> 
            
            <div class="prev_next">
                <ul class="inner_next">
                    <li class="link_page on"><a href="#">1</a></li>
                    <li class="link_page"><a href="#">2</a></li>
                    <li class="link_page"><a href="#">3</a></li>
                    <li class="link_page"><a href="#">4</a></li>
                    <li class="link_page"><a href="#">5</a></li>
                    <li class="pgN">
                        <a href="#">
                            <span class="bd_next">다음</span>
                        </a>
                   </li>
                </ul>
            </div><!--prev_next-->
          </div><!--#board_contents -->

<%@ include file="footer.jsp" %>
</div><!-- #wrap -->

</body>
</html>