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
          
    <link href="../resources/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="../resources/css/metisMenu.css" rel="stylesheet" type="text/css">
    <link href="../resources/css/font-awesome.css" rel="stylesheet" type="text/css">
    
    <!-- jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script type="text/javascript" src="../resources/js/bootstrap.js"></script>
    <script type="text/javascript" src="../resources/js/metisMenu.js"></script>
    <script type="text/javascript" src="../resources/js/sb-admin-2.js"></script>
    <script type="text/javascript" src="../resources/js/detail.js"></script>
</head>
<body>
	  <div class="form-group row">
	  	<div id="bno" class="col-sm-12 mb-3 mb-sm-0">${detail.bno}</div>
	    <div class="col-sm-12 mb-3 mb-sm-0">
	         ${detail.title}
	    </div>
		<div class="col-sm-12 mb-3 mb-sm-0">
			${detail.content}
		</div>
		<div class="col-sm-12 mb-3 mb-sm-0">
			<a href="/board2/modify?bno=${detail.bno}">수정</a>
			<a href="/board2/remove?bno=${detail.bno}">삭제</a>
		</div>
		
		<div id="uploadResult" >
			<ul>
			</ul>
		</div>
		
        <div class="panel-body">
           <!-- Button trigger modal -->
           <button id="addReplyBtn" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
               		댓글
           </button>
           <!-- 댓글창은 따로jsp파일을 생성하지 않아서 여기에 붙여서 사용 -->
           
           <div>
           		<ul id="relist"></ul>
           </div>
           
           
           
           
           
           
           <!-- Modal -->
           <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
               <div class="modal-dialog">
                   <div class="modal-content">
                       <div class="modal-header">
                           <h4 class="modal-title" id="myModalLabel">댓글 쓰기</h4>
                       </div>
                       <div class="modal-body">
                       <div>
                      		<input type="text" name="rno" class="from-control">
                       	</div>
                       	<div>
                       		<label>Replyer</label>
                      		<input type="text" name="replyer" class="from-control">
                       	</div>
                       	<div>
                       		<label>Reply</label>
                       		<input type="text" name="reply" class="from-control">
                       	</div>
                       </div>
                       <div class="modal-footer">
                           <button id="modalRegisterBtn" type="button" class="btn btn-primary">댓글 쓰기</button>
                           <button id="modalModBtn" type="button" class="btn btn-primary">댓글 수정</button>
                           <button id="modalRemoveBtn" type="button" class="btn btn-primary">댓글 삭제</button>
                           <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                           
                       </div>
                   </div>
                   <!-- /.modal-content -->
               </div>
               <!-- /.modal-dialog -->
           </div>
           <!-- /.modal -->
        </div>
	</div>
</body>
</html>
