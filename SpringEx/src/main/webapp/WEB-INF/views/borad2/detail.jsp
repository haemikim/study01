<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/all.css">
	<link rel="stylesheet" type="text/css" href="../resources/css/sb-admin-2.css">
	<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">
</head>
<body>
	  <div class="form-group row">
	    <div class="col-sm-12 mb-3 mb-sm-0">
	         ${detail.title}
	    </div>
		<div class="col-sm-12 mb-3 mb-sm-0">
			${detail.content}
		</div>
		<div class="col-sm-12 mb-3 mb-sm-0">
			<a href="/board/modify?bno=${detail.bno}">수정</a>
			<a href="/board/remove?bno=${detail.bno}">삭제</a>
		</div>
	</div>
</body>
</html>
