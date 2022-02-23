let userId = document.querySelector("#user_id");
let pw1 = document.querySelector("#user_pw1");
let pw2 = document.querySelector("#user_pw2");
let pw2Sp = document.querySelector("#user_pw2_sp");
let userName = document.querySelector("#user_name");
let userEmail = document.querySelector("#user_email");
let phone = document.querySelector("#phone");
let submit = document.querySelector("#submit");


let nameCheck = /^(?=.*[가-힣]).{2,10}$/;
let idCheck = /^(?=.*[a-zA-Z])(?=.*[0-9]).{8,20}$/;
let pwdCheck = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$/;
let emailCheck = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
let phoneCheck = /^(01[016789]{1})-?[0-9]{3,4}-?[0-9]{4}$/; // 정규식 표현

userId.onchange = checkId;
pw1.onchange = checkPw; // 그냥 기능인데 이렇게 작성해도됨 아니면 jspdp onchange넣어서 사용하거나 상관없음
pw2.onchange = comparePw;
userName.onchange = checkName;
userEmail.onchange = checkEmail;
phone.onchange = checkPhone;
submit.onclick = checkJoin;

function checkName(){
	// test()메서드는 정규표현식을 만족하는지 true or false로 판별
	if (!nameCheck.test(userName.value)) { // 이름의value값이 nameheck라는 유효성 검사에 적절하지 않으면 실행
		document.querySelector("#user_name_sp").innerHTML="<font color=#e43530>올바른 이름을 입력해주세요</font>";
		userName.focus();// 선택요소가 포커스를 가지게 된다(커셔의 깜빡임)
	}else {
		document.querySelector("#user_name_sp").innerHTML="";
	}
}

function checkId(){

	if (!idCheck.test(userId.value)) {
		  document.querySelector("#user_id_sp").innerHTML="<font color=#e43530> ID는 영문자+숫자 조합으로 8~20자리 사용해야 합니다</font>";
		  userId.focus();
	}else {
		  document.querySelector("#user_id_sp").innerHTML="";
	}
}

function checkPw(){

	if (!pwdCheck.test(pw1.value)) {
		  document.querySelector("#user_pw1_sp").innerHTML="<font color=#e43530> 비밀번호는 영문자+숫자+특수문자 조합으로 8~20자리 사용해야 합니다</font>";
		  pw1.focus();
	}else {
		  document.querySelector("#user_pw1_sp").innerHTML="";
	}
}

function comparePw(){
	
    if(pw1.value != pw2.value){
        document.querySelector("#user_pw2_sp").innerHTML="<font color=#e43530>암호가 다르니 다시 입력해주세요</font>";
        pw2.value = "";
        pw2.focus();
    }else{
        document.querySelector("#user_pw2_sp").innerHTML="<font color=#00BFFF>비밀번호가 일치합니다</font>";
    }
}

function checkEmail() {
	
	if(!emailCheck.test(userEmail.value)){
		document.querySelector("#user_email_sp").innerHTML="<font color=#e43530>올바른 이메일이 아닙니다</font>"
		userEmail.focus();
	}else{
		document.querySelector("#user_email_sp").innerHTML=""
	}
}

function checkPhone() {
	
	if(!phoneCheck.test(phone.value)){
		document.querySelector("#user_phone_sp").innerHTML="<font color=#e43530>올바른 휴대전화 번호가 아닙니다</font>"
		phone.focus();
	}else{
		document.querySelector("#user_phone_sp").innerHTML=""
	}
}

function checkJoin() {

	if (!nameCheck.test(userName.value)) {
		alert("이름을 확인해주세요");
		userName.select();
		return false;
	}
	if (!idCheck.test(userId.value)) {
		alert("ID를 확인해주세요");
		userId.select();
		return false;
	}
	if (!pwdCheck.test(pw1.value)) {
		alert("비밀번호를 확인해주세요");
		pw1.select();
		return false;
	}
	if(pw1.value != pw2.value){
		alert("비밀번호를 확인해주세요");
		pw2.select();
		return false;
    }
	if(!emailCheck.test(userEmail.value)){
		alert("이메일을 확인해주세요");
		userEmail.select();
		return false;
	}
	if(!phoneCheck.test(phone.value)){
		alert("휴대전화 번호를 확인해주세요");
		phone.select();
		return false;
	}

	
	
	document.checkJoin.submit();
}