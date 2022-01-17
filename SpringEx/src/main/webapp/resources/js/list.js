/**
 * 폼테그의 search와 keyword를 가지고 와라 
 */
$(document).ready(function(){
	var actionForm = $("#actionForm")
	// 현재페이지 번호를 클릭하면
	$(".paginate_button a").on("click",function(e){
		//alert("aaa")
		e.preventDefault();
		// form태그안에 있는 pageNum 값을 가지고 와라           	// this : 내가 선택한 페이지 넘버
		actionForm.find("input[name='pageNum']").val($(this).attr("href"))
		// actionForm.find("input[name='pageNum']") = <input type="text" name="pageNum" value="${pageMaker.cri.pageNum}"> 
		// val  = ${pageMaker.cri.pageNum}
		// attr("href") = 내가 선택한 값(페이지 넘버)을 "${pageMaker.startPage-1}, ${num}, ${pageMaker.endPage+1}에 넣어라
		//form태그 안에 있는 값을  controller로 보내라
		actionForm.submit();
	})//$("a")로 작성하면 a태그 전부가 선택된다
	
	// form테그 안에 있는 값을 가지고 와라
	
	//검색버튼을 클릭하면
	$("input[type='submit']").on("click",function(e){
		e.preventDefault();
		// pageNum의 값을 1로 설정(검색결과에 대한 페이지와 내가 있는 페이지가 달라도 검색히면 첫번째 페이지로 가게 해준다)
		actionForm.find("input[name='pageNum']").val("1") // 결과값이 1번째 페이지부터 나오돌고 설정
		actionForm.submit();
	})
})
