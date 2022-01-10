package org.jht.controller;

import org.jht.domain.BoardDTO;
import org.jht.domain.Criteria;
import org.jht.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("board2")
// 이렇게 공통적으로 앞에 붙여야하는 부분을 따로 먼저 선언을 하고 나머지는 타입에 따라 선언한다 
public class BoardController {
	@Autowired
	// priva  te BoardService service = new BoardService();
	private BoardService service;
	// 글쓰기 화면으로....
	@GetMapping("write")
	public void write() {
		System.out.println("board2/write");
	}
	
	// 글쓰기 버튼을 클릭하면...
	@PostMapping("write")
	public String writePost(BoardDTO board) {
		service.write(board);
		System.out.println("write post....."+board);
		
		return "redirect:/board2/list";
	}
	// 게시판 목록 리스트
	@GetMapping("list")
	public void list(Criteria cri,Model model) {
		System.out.println("board2/list");
		model.addAttribute("list", service.list(cri));		
	}
	// 게시판 목록 리스트에서 제목을 클릭하면....
	@GetMapping("detail")
	public void detail(BoardDTO board,Model model) {
		model.addAttribute("detail",service.detail(board));
	}
	// 글수정 화면으로....
	@GetMapping("modify")
	public void modify(BoardDTO board,Model model) {
		model.addAttribute("detail",service.detail(board));
		System.out.println("board2/modify");
	}
	// 글수정 버튼을 클릭하면.....
	@PostMapping("modify")
	public String modifyPost(BoardDTO board,RedirectAttributes rttr) {
		System.out.println(board);
		//update
		service.modify(board);
		rttr.addAttribute("bno", board.getBno());
		return "redirect:/board2/detail";
	}
	// 글삭제 버튼을 클릭하면.....
	@GetMapping("remove")
	public String remove(BoardDTO board) {
		System.out.println(board);
		service.remove(board);
		return "redirect:/board2/list";
	}	
}





