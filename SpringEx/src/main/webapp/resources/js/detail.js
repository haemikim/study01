/**
 * 
 */	
	var replyService=(function(){//함수선언
		//댓글쓰기(add)를 하기 위한 함수선언
		function add(reply, callback){// 각각  위의  reply, function 부분을 들고온다
			console.log("reply,,,") //  콘솔부분에 출력
			$.ajax({
				url:"/replies/new",  // 주소 형식(controller에 있는 new랑 연결용 )
				type:"post",
				data:JSON.stringify(reply),  // JSON.stringify : 자바스크립트 값을 JSON 문자열로 변환(변환시킬것)
				contentType:"application/json;charset=utf-8", // 출력 값을 한글로 전환시키는 것
				success:function(result){// 통신이 정상적으로 성공했으면 
				// controller에서 result값이 1이면 성공result값을 반환해져서 선언한 여기에 반환됨
					console.log(result); 
					// callback함수선언
					// 만약에 callback이 있으면
					if(callback) // controller로 보낸후 다시 불러온다 (성공적으로 적용한뒤 하는 것)
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
	function reupdate(reply,callback){
		$.ajax({
			url:"/replies/update",
			type:"put",
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
	// 댓글삭제를 하기위한 함수선언
	function remove(reply, callback){// 각각  위의  reply, function 부분을 들고온다
		$.ajax({
			url:"/replies/remove",  // 주소 형식(controller와 연결시킴)
			type:"delete",
			data:JSON.stringify(reply),  // JSON.stringify : 자바스크립트 값을 JSON 문자열로 변환(변환시킬것)
			contentType:"application/json;charset=utf-8", // 출력 값을 한글로 전환시키는 것
			success:function(result){// 통신이 정상적으로 성공했으면 
			// controller에서 result값이 1이면 성공result값을 반환해져서 선언한 여기에 반환됨
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
	
	/// 선언 > 컨트롤러 > 콜백 > 호출
	
		return {// 메모리 올라가 있던걸 다시 회수하여 관리하는 역할
			add:add,  // json 형식 작성법이 이러한 형식(json형식 작성 법이 아니면 그냥add만 작성가능)
			getList:getList, 
			reDetail:reDetail, // 호출한 곳으로 다시 보내준다
			reupdate:reupdate,
			remove:remove
			};
		
})() //var=service로 한거에 대한 괄호

$(document).ready(function(){
	// bno값
	var bno=$("#bno").html();
	
	// 상세페이지가 시작하자마자 이미지를 출력하기 위한 Ajax
	$.getJSON("/board2/fileList/"+bno+".json",
		function(data){ // BoardController에 있는 fileList를 통해 얻어진 select결과를 data에 저장한 후,
		    // detail.jsp에 뿌리기
			var str="";
			console.log(data)
			$(data).each(function(i,obj){
				if(!obj.image){  // 사용자가 업로드한 파일의 타입이 이미지가 아니면(excel문서파일, ppt),
					var fileCallPath = encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName)
					str+="<li data-path='"+obj.uploadPath+"'";
					str+="data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"'>";
					str+="<a href='/download?fileName="+fileCallPath+"'>"+obj.fileName+"</a></li>"
				}else{// 사용자가 업로드 한 파일의 타입이 이지미면(.inp, .png, .git),
					var fileCallPath = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName)
					//console.log(fileCallPath);
					// imge태그를 사용해서 웹브라우저레 출력
					str+="<li data-path='"+obj.uploadPath+"'";
					str+="data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"'>";
					str+="<img src='/display?fileName="+fileCallPath+"'></li>"
				}	
		})
			$("#uploadResult ul").html(str) // 덮어쓰기 형태로 나옴
	})	
	
	
	
	
	
	
	
	// 상세페이지가 실헹되면 글쓰기버튼은 비활성화
	$("#modalRegisterBtn").modal("hide");
	// 상세페이지가 실헹되면 수정버튼은 비활성화
	$("#modalModBtn").modal("hide");
	// 상세페이지가 실헹되면 삭제버튼은 비활성화
	$("#modalRemoveBtn").modal("hide");
	
	// 댓글쓰기 버튼을 클릭하면
	$("#addReplyBtn").on("click",function(){
		// Replyer input 내용초기화
		$("input[name='replyer']").val("")
		// Reply input 내용초기화
		$("input[name='reply']").val("")
		// rno input 내용초기화
		$("input[name='rno']").val("")
		// 새로운 시작이니 버튼 다시 보이게 설정
		$("#modalRegisterBtn").show();

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
				str+="<li data-rno='"+list[i].rno+"'><div><b>"+list[i].replyer+"</b></div>"
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
	$("#relist").on("click","li",function(){// click이벤트 범위가ul이였는데 li로변경
		
		// rno값을 가져오기  // this는 내가 선택한 값을 가져오는것
		var rno=$(this).data("rno");

		
		replyService.reDetail(rno,function(detail){
			
			console.log(detail)

		$("input[name='rno']").val(detail.rno) 
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
	// 댓글수정버튼을 눌렀을때
	$("#modalModBtn").on("click",function(){
		//alert("aaa"); 연결된건지 확인용
	
		var reply = {rno:$("input[name='rno']").val(),reply:$("input[name='reply']").val()}; // 해당 댓글의 번호와 내용 수정
		console.log(reply);
		// 댓굴수정함수를 호출해서 처리
		replyService.reupdate(reply,function(update){
			// 콜백영역(update가 정상적으로 처리된후 조치)
			alert("update 작업: "+update); // 수정후 알림창이 뜸(controller에서 가져온update결과값을 띄운다)
			// 모달창 닫고
			$(".modal").modal("hide"); // 수정을 누르면 자동으로 사라지게 설정
			// 목록리스트를 실행
			showList(); // 변경된 값으로 새로고침을 누르지 않고 바로 보이게 함수를 들고와서 실행시킨다

	})
	
	
})	

	// 댓글 삭제버튼을 클릭하면
	$("#modalRemoveBtn").on("click",function(){
		// alert("dd"); 연결된건지 확인용
	
		var reply = {rno:$("input[name='rno']").val()} // 해당하는 댓글번호만 삭제
		// 댓글삭제 함수를 호풀해서 처리
		replyService.remove(reply,function(remove){  
			// 콜백영역(update가 정상적으로 처리된후 조치)
			alert("remove 작업: "+remove); // 수정후 알림창이 뜸(controller에서 가져온update결과값을 띄운다)
			// 모달창 닫고
			$(".modal").modal("hide"); // 수정을 누르면 자동으로 사라지게 설정
			// 목록리스트를 실행
			showList(); //
			
		})
	})
	// 댓글 삭제 함수를 호출해서 처리
	
	
	
	
	
	

}) 	// $(document).ready(function(){ 끝,,











