package org.ex.controller;

import org.ex.domain.Board3DTO;
//import org.ex.service.Board3Service;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board3")
public class Board3Controller {
// @Autowired

//private Board3Service bservice;
	@GetMapping("write")
	public void write() {
		System.out.println("/board3/write");
	}
	
	@PostMapping("write")
	public String writePost(Board3DTO dto) {
		return null;
	}
	
	
	
}
