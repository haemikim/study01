package org.jht.controller;

import javax.servlet.http.HttpSession;

import org.jht.domain.MemberDTO;
import org.jht.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	private MemberService mservice;
	
	
	@GetMapping("member")
	public void member() {
		System.out.println("member/member");
	}
	// 회원가입 화면을 통해 얻어진 데이터 insert
	@PostMapping("member")
	public void Postmember(MemberDTO mdto) {
		mservice.insert(mdto); // 연결
	}
	// login화면 이동
	@GetMapping("login")
	public void login() {
		System.out.println("member/login");
	}
	// 로그인  화면을 통해 얻어진 데이터를 활용하여 select
	@PostMapping("login")
	public String Postlogin(MemberDTO mdto, HttpSession session) {// session : 
		MemberDTO login=mservice.login(mdto);
		
		// MemberDTO에 있는[id=abcd, password=1234, name=정자바]를 세션여역에 login이라는 변수에 저장
		// session객체에 		login변수에 login값(MemberDTO값)을 저장(setAttribute)
		session.setAttribute("login", login); // 모델이랑 사용이 똑같음(model은 list.jsp파일만 연결이 되서, session은 다른.jsp에도 영향을 미친다)
		
		 // session.invalidate(); session에 있는 걸 모두 지우는것 (로그아웃)
		
		// session영역에 login이라는 변수에 값이 있으면 호그인 된 채로
		if(session.getAttribute("login")!=null) {
			// main페이지로 이동
			return "redirect:/"; //redirect : 서로 다른 컨트롤러를 연결할때 사용
		}else { // session영역에 login이라는 변수에 값이 없으면(null)
			// 다시 로그인 할 수 있게 로그인 페이지로 이동
			return "redirect:/member/login";
		}
		
		
	}
	
	
	
}
