<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  <!--c 어쩌구를 j s p 에 적용시킬려고 사용하는 것 -->  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/all.css">
	<link rel="stylesheet" type="text/css" href="../resources/css/sb-admin-2.css">
	<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js">
    </script>
    <script type="text/javascript" src="../resources/js/list.js"></script>
</head>
<body>
	<h1>게시판 목록 리스트</h1>
	<div class="card-body">
       <div class="table-responsive">
           <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
               <thead>
                   <tr>
                       <th>게시판번호</th>
                       <th>제목</th>
                       <th>작성자</th>
                       <th>작성일</th>
                       <th>조회수</th>
                       <th>좋아요</th>
                   </tr>
               </thead>
               <tbody>
               <!-- jstl에서 사용되는 문법 형식이< % % >문대신 $ { q} 문으로 사용된다 -->
               <!-- forEach는 반복문 -->
                            <!-- for(변수명 : 배열){}과 같은 형식 -->
                            <!-- item: 데이터를 저장하는 구조 (list, Array), 배열 -->
               		<c:forEach items="${list}" var="board"><!-- var = 변수명 (memberDTO의 변수명) -->
						<tr>
						    <td>${board.bno}</td>
						    <td><a href="/board2/detail?bno=${board.bno}">${board.title}</a></td>
						    <td>${board.writer}</td>
						    <td>${board.regdate}</td>
						    <td>${board.cnt}</td>
						    <td>${board.good}</td>
						</tr>
                   </c:forEach>
               </tbody>
           </table>
                   <!--jsp에 있는 name이랑 DTO에 클래스가 있으면 보낼수가있다-->
           <form id="actionForm" action="/board2/list" method="get">
	           <div class="form-control bg-light border-0 small"> <!-- BoardController에 list부분에 model로 사용! -->
	           	<input type="text" name="pageNum" value="${pageMaker.cri.pageNum}">
	           	<input type="text" name="amount" value="${pageMaker.cri.amount}">
	                 <select name="search">
	                 	 <option value="T">제목</option>
	                 	 <option value="C">내용</option>
	                 	 <option value="W">작성자</option>
	                 	 <option value="TC">제목 + 내용</option>
	                 	 <option value="TCW">제목 + 내용 + 작성자</option>
	                 </select>
	                 <input type="text" name="keyword" value="${pageMaker.cri.keyword}">
	                 <input type="submit" value="검색">
                   </div>
             </form>
                   <div class="col-sm-12 col-md-7 dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
                   <ul class="pagination">
	                    <c:if test="${pageMaker.prev}">
		                   	<li class="paginate_button page-item previous" id="dataTable_prev">
		                   		<a href="${pageMaker.startPage-1}" class="page-link">이전</a>
		                   	</li>
		                </c:if>	   	
	                   	<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
		                   	  <li class="paginate_button page_item">
		                   	   	<a href="${num}" class="page-link">${num}</a>
		                   	  </li>
	                   	</c:forEach>
		                <c:if test="${pageMaker.next}">
		                   	<li class="paginate_button page_item next" id="dataTable_next">
		                   		<a href="${pageMaker.endPage+1}" class="page-link">다음</a>
		                   	</li>
	                   	</c:if>
                   </ul>
                    
                  </div>
       </div>
	</div>
</body>
</html>