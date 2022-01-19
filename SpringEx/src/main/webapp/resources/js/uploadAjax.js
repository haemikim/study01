$(document).ready(function(){
	
	// 파일의 크기와 확장자를 검사하는 함수선언
	// 서버에서 설정해놓은 파일크기 설정
	var maxSize=5242880; // 5MB
	// 서버에서 허용가능한 확장자 설정(정규식)
	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$"); // 사용자가 선택한 파일이()안에 속한 종류인지 검증
	
	function checkExtension(fileSize, fileName){ //(파일의 크기, 확장자)
		//if(사용자가 선택한 파일크기 >= 서버에서 설정해놓은 파일크기)
		// 사용자가 선택한 파일의 크기가 서버에서 설정해 놓은 파일의 크기보다 이상이면,
		if(fileSize>=maxSize){
			alert("파일 사이즈 초과");
			return false;
		}
		// 사용자가 선택한 파일의 확장자가 서버에서 설정해놓은 파일의 확장자와 일치하면
		//if(확장자~~~~)
		if(regex.test(fileName)){ // test()메서드는 문자열의 일치여부를 확인한다
			alert("해당종류의 파일은 업로드 할 수 없습니다");
			return false;
		}
		return true;
	}
	
	var formObj =$("form[role='form']")
	// 글쓰기 버튼을 클릭하면
	$("input[type='submit']").on("click",function(e){
		e.preventDefault(); 
		var str="";
		// 각li태그에 있는
		$("#uploadResult ul li").each(function(i,obj){
			console.log(obj);
			// data선책자를 이용하여 input태그의 value값으로 셋팅
			/*
			 * jQuuery data-xx data함수
			 * <span>
			 * $("span").data("age",13) => <span data-age="13"> data함수 괄호안에 매개변수가 두개면  setter
			 * <span data-age="13">
			 * $("span").data("age") => 13 data함구 괄호안에 매개변수가 하나면getter
			 * 
			 */
			str+="<input type='text' name+'attachList["+i+"].fileName' value='"+$(obj).data("filename")+"'>"
			str+="<input type='text' name+'attachList["+i+"].uuid' value='"+$(obj).data("uuid")+"'>"
			str+="<input type='text' name+'attachList["+i+"].uploadPath' value='"+$(obj).data("path")+"'>"
			str+="<input type='text' name+'attachList["+i+"].image' value='"+$(obj).data("type")+"'>"
		})
		formObj.append(str);
	})
	
	// 파일 선택의 내용이 변경되면
	
	$("input[type='file']").on("change",function(){ // 전송 누르면 보낼 데이터를 저장할 공간 생성
		//alert("aaa"); 연결확인
		//가상의 form태그
		var formData = new FormData(); // form태그의 데이터를 저장할 공간생성
		var inputFile=$("input[name='uploadFile']"); // inputFile에 jsp의 input name성질을 들고와서 사용
		var files=inputFile[0].files; // files에 inputFile을 [0]부터 files들을 저장
		
		console.log(files); // console로 확인		
		for(var i=0;i<files.length;i++){ // files 전체 확인
			// 파일의 크기가 이상이면 
			if(!checkExtension(files[i].size,files[i].name)){
				// 밑에 있는거 하지마라
				return false;
			}
			formData.append("uploadFile",files[i]); // 가상의 form태그의 uploadFile에 files를 저장시킨다 
			// append를 통해서 정보를 계속해서 누적시켜준다
		}
		// ajax을 이용해서
		// formData 자체를 데이터로 전송하고,
		// formData를 데이터로 전송할 때에는
		// processData와 contentType은 반드시 false여야함
		$.ajax({
			url:"/uploadAjaxAction",
			type:"post",
			data:formData,
			processData:false,
			contentType:false,
			success:function(result){// 사용자가 선택한 파일을 원하는 경로에 성공적으로 업로드 한 후....
				// showUploadedFile함수 호출
				showUploadedFile(result);
			}
		
		})//$.ajax 끝
		// 사용자가 선택한 파일을 원하는 경로에 성공적으로 업로드 한 후 웹브라우저에 파일을 띄워라에 대한 함수선엄(showUploadedFile)
	})
})// $(document).ready(function() 끝

// 사용자가 선택한 파일을 원하는 경로에 성공적으로 업로드 한 후 웹브라우저에 파일을 띄워라에 대한 함수선엄(showUploadedFile)
function showUploadedFile(uploadresultArr){
	var str="";
	$(uploadresultArr).each(function(i,obj){ // each는 jquery에서의 for문
		 console.log(obj);
		if(!obj.image){  // 사용자가 업로드한 파일의 타입이 이미지가 아니면(excel문서파일, ppt),
			var fileCallPath = encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName)
			str+="<li data-path='"+obj.uploadPath+"'";
			str+="data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"'>";
			str+="<img src='/display?fileName="+fileCallPath+"'></li>"
		}else{// 사용자가 업로드 한 파일의 타입이 이지미면(.inp, .png, .git),
			var fileCallPath = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName)
			//console.log(fileCallPath);
			// imge태그를 사용해서 웹브라우저레 출력
			str+="<li data-path='"+obj.uploadPath+"'";
			str+="data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"'>";
			str+="<img src='/display?fileName="+fileCallPath+"'></li>"
		}	
				
	})
	$("#uploadResult ul").html(str)
}

