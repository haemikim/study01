<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="uploadAction" method="post" enctype="multipart/form-data"> <!-- enctype은 파일 업로드나 이미지 업로드를 서버로 전송할때 사용 -->
	<input type="file" name="uploadFile" multiple> <!-- 파일타입은 기존의 파일에서 파일을 선택할 수 있다  -->
	<!-- multiple은 파일을 여러개 선택할수있게 해준다 / multiple이 배열이 아니면 결과값이 하나 나옴  -->
	<input type="submit" value="전송">
</form>
</body>
</html>
