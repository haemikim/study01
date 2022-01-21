package org.ex.controller;

import org.ex.domain.Board3DTO;
import org.ex.domain.Criteria;
import org.ex.service.Board3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board3")
public class Board3Controller {
	
	@Autowired
	private Board3Service bservice; // 연결
	
	// 글쓰기 화면
	@GetMapping("write")
	public void write() {
		System.out.println("/board3/write"); // 작동이 되면 console에 띄우기
	}
	// 글쓰기 버튼을 클릭하면
	@PostMapping("write") // post타입인 이유 : 한가지 내용을 들고오는게 아니라서
	public String writePost(Board3DTO dto) {
		System.out.println("write post.."+dto); 
		// 작동하면 메세지랑 작성한 내용 띄우기
		bservice.write(dto); 
		// 사용자가 작성한 데이터를 들고온다
		return "redirect:/board3/list"; 
		// 글쓰기 버튼을 누르면 list창을 띄워라
	}
	// 게시판 리스트
	@PostMapping("list")
	public void list(Criteria cri, Model model) {
		System.out.println("리스트의 제목을 누르셧나여"+cri);
		
//		model.addAttribute("list", )
	}
	
	
	
}
