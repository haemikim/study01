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
	
	
	$("input[type='submit']").on("click",function(){ // 전송 누르면 보낼 데이터를 저장할 공간 생성
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
			url:"uploadAjaxAction",
			type:"post",
			data:formData,
			processData:false,
			contentType:false,
			success:function(result){
				alert("upload 성공")
			}
		
		})
	})
})