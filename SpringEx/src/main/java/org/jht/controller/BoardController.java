 package org.jht.controller;

import java.util.ArrayList;

import org.jht.domain.AttachFileDTO;
import org.jht.domain.BoardDTO;
import org.jht.domain.Criteria;
import org.jht.domain.PageDTO;
import org.jht.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("board2")
// 이렇게 공통적으로 앞에 붙여야하는 부분을 따로 먼저 선언을 하고 나머지는 타입에 따라 선언한다 
public class BoardController {
	@Autowired
	// private BoardService service = new BoardService();
	private BoardService service; //boardService랑 연결
	// 글쓰기 화면으로....
	@GetMapping("write")
	public void write() {
		System.out.println("board2/write"); // 잘 작동하면 console에 띄우기
	}
	
	// 글쓰기 버튼을 클릭하면...
	@PostMapping("write")
	public String writePost(BoardDTO board) {
		System.out.println("write post....."+board);
		// 잘 작동하면 console에 메시지와 작성한 메모 띄우기
		
		service.write(board); // 사용자가 작성한 데이터를 들고온당
		
		return "redirect:/board2/list";
	}
	// 게시판 목록 리스트(데이터베이스에서 데이터를 들고과서 게시판목록에 뿌린다)
	@GetMapping("list") // cri는 페이징
	public void list(Criteria cri,Model model) { // 연결된 model들은 jsp에있다
		System.out.println("board2/list="+cri);
								
		model.addAttribute("list", service.list(cri));
		//pageDTO의 데이터를 jsp에 부린다
		int total=service.getTotalCount(cri);
		model.addAttribute("pageMaker", new PageDTO(cri,total));
	}
	// 게시판 목록 리스트에서 제목을 클릭하면....
	@GetMapping("detail")
	public void detail(BoardDTO board,Model model) {
									
		model.addAttribute("detail",service.detail(board));
	}
	// /board/fileList/
	// 게시판 상세페이지에서 이미지를 출력하기위한 select된 결과를 javascript
	@GetMapping(value="fileList/{bno}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ArrayList<AttachFileDTO>> fileList(@PathVariable int bno){
		System.out.println("fileList");
		return new ResponseEntity<>(service.fileList(bno),HttpStatus.OK);
	}
	
	// 글수정 화면으로....
	@GetMapping("modify")          // 
	public void modify(BoardDTO board,Model model) {
		model.addAttribute("detail",service.detail(board));
		System.out.println("board2/modify");
	}
	// 글수정 버튼을 클릭하면.....
	@PostMapping("modify")       //RedirectAttributes Model에 들어있는 primitive type 데이터는 URI 쿼리 매개변수에 추가된다.
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






