/**
 * 
 */	
	var replyService=(function(){//함수선언
		//댓글쓰기(add)를 하기 위한 함수선언
		function add(reply, callback){// 각각  위의 add, function 부분을 들고온다
			console.log("reply,,,")
			$.ajax({
				url:"/replies/new",
				type:"post",
				data:JSON.stringify(reply),  // JSON.stringify : 자바스크립트 값을 JSON 문자열로 변환
				contentType:"application/json;charset=utf-8",
				success:function(result){// 통신이 정상적으로 성공했으면
					console.log(result);
					// callback함수선언
					// 만약에 callback이 있으면
					if(callback)
					// callback함수를 호풀	
						callback(result);
				},
				error:function(){			// 통신이 비정상적으로 처리가 되어error가 있으면
					
				}
			})	
		}

	//댓글 목록 리스트를 하기위한 함수선언
	function getList(param,callback){
		var bno=param.bno;
		console.log(bno);
		$.getJSON(
				"/replies/list/"+bno+".json",
				function(data){
					if(callback)
						callback(data);
				}
			)
				
	}	
	//댓글수정을 하기위해 댓글내용 가져오기(함수선언)
	function reDetail(rno,callback){
		$.getJSON(
				"/replies/"+rno+".json",
				function(data){
					console.log(data);
					if(callback)
						callback(data)
				})
	}
	//댓글수정을 하기위한 함수선언
	
	//댓글삭제를 하기위한 함수선언
	
		return {
			add:add,
			getList:getList,
			reDetail:reDetail
			};
		
})()

$(document).ready(function(){
	// 상세페이지가 실헹되면 글쓰기버튼은 비활성화
	$("#modalRegisterBtn").modal("hide");
	// 상세페이지가 실헹되면 수정버튼은 비활성화
	$("#modalModBtn").modal("hide");
	// 상세페이지가 실헹되면 삭제버튼은 비활성화
	$("#modalRemoveBtn").modal("hide");
	
	// 댓글쓰기 버튼을 클릭하면
	$("#addReplyBtn").on("click",function(){
		//모달창을 띄어라
		$(".modal fade").modal("show");
		
	});
	//bno값
	var bno=$("#bno").html();

		showList(); // detail.jsp가 시작되자마다 댓글목록 리스트가 실행되어야함 
	
	function showList(){
// datail.jsp가 시작되자마다 댓글목록 리스트가 실행되어야함  //function(익명함수)
		replyService.getList({bno:bno},function(list){
			
			console.log(bno);
			var str="";
			
			for(var i=0; i<list.length;i++){
				str+="<li><div><b>"+list[i].replyer+"</b></div>"
				str+="<div>"+list[i].reply+"</div>"
				str+="</li>"	
			}
			
			$("#relist").html(str)
			
		});
		
	}	
	// console.log(replyService); //replyService 함수 호출
	// 댓글쓰기 버튼(id가 값이 modalRegisterBtn)은 클릭하면
	$("#modalRegisterBtn").on("click",function(){
		// 사용자가 입력한 댓글내용을 저장
		var reply=$("input[name='reply']").val() // ()가 있어야 지정한 값을 저장할수있다 아니면 null로 인식
		// 사용자가 입력한 댓글 작성자를 저장
		var replyer=$("input[name='replyer']").val()
		// 				  ajax보내고자하는 json타입	
		replyService.add({reply:reply,replyer:replyer,bno:bno}, 
				function(result){		//callback함수호출	
								alert("insert 작업: "+ result)
								//목록리스트를 처리 (위의 함수를 들고옴 /복붙해도 되지만 간결한 코드와 유지보수를 위해 함수사용 )
								showList();
		 	}
		
	   );
		
		// 모달창을 숨겨라
		$(".modal").modal("hide");
	})// 모달창안에 댓글쓰기 버튼
	// 댓글 내용을 클릭하면(수정,삭제를 위한 창띄우기는 필수!)
	$("#relist").on("click",function(){
		
		replyService.reDetail(14,function(detail){
			console.log(detail)
			console.log(detail.replyer)
			console.log(detail.reply)
			
		$("input[name='replyer']").val(detail.replyer) 
		$("input[name='reply']").val(detail.reply)
			
		// 수정하는거니 글쓰기버튼은 비활성화
		$("#modalRegisterBtn").hide();
		// 글수정버튼 비황성화
		$("#modalModBtn").show(); 
		// 글삭제버튼 비활성화
		$("#modalRemoveBtn").show();
		// modal창을 띄워라  //위에 모달창띄우는것과 동일함
		$(".modal").modal("show"); //>>??이건 왜 fade 붙이면 안되냐?

		
	})
	
})	
	
	
	
	
	
	
	
	
	

}) 	// $(document).ready(function(){ 끝,,











