package org.jht.controller;

import org.jht.domain.ReplyDTO;
import org.jht.service.ReplyServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("replies")
public class ReplyController {
	@Autowired
	private ReplyServiceIml reservice;
	// 댓글쓰기를 하기위한 RequesMapping
	// mapping을 할떄 우리가 원하는 데이터 타입을 강제함으로써 오류상황을 줄일 수 있다
	// consumes : 들어오는 데이터 타입 정의(생략가능)
	// produces : 들어오는 데이터 타입 정의(생략가능)
	// * 생략을 하게되면, 웹브라우저가 알아거 타입을 판단 *
	@PostMapping(value="new",consumes="application/json", produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyDTO rdto){
		System.out.println("ReplyDTO="+rdto);

		return null;
		
	}
}
