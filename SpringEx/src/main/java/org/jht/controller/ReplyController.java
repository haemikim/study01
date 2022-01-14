package org.jht.controller;

import java.util.ArrayList;

import org.jht.domain.ReplyDTO;
import org.jht.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// 이친구들을 이런식으로 연결할땐 return 받아서 사용하는거라void는 절대 사용할수없음!

@RestController
@RequestMapping("replies")
public class ReplyController {
	@Autowired
	private ReplyService rservice;
	// 댓글쓰기를 하기위한 RequesMapping
	// mapping을 할떄 우리가 원하는 데이터 타입을 강제함으로써 오류상황을 줄일 수 있다
	// consumes : 들어오는 데이터 타입 정의(생략가능)
	// produces : 반환하는 데이터 타입 정의(생략가능)
	// * 생략을 하게되면, 웹브라우저가 알아거 타입을 판단 *
	@PostMapping(value="new",consumes="application/json", produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyDTO rdto){
		System.out.println("ReplyDTO="+rdto);
		// insert 성공시 ReplyMapper.xml로 부터1
		// insert 성공시 ReplyMapper.xml로 부터0
		// 값을 리턴받는다
		int result=rservice.write(rdto);
		System.out.println("result="+result);
		//	                          insert가 정상적으로 처리가 되었을떄	
		return result==1?new ResponseEntity<>("success",HttpStatus.OK) //새로운 생성자  <배열> 성공, 코드상태.ok
						:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		//									  insert가 비정상적으로 처리가 되었을떄
	}// js에 getList의JSON주소를 가져온다
	@GetMapping(value="list/{bno}", produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
													 // REST방식에서 주로 사용.URL경로의 일부를 파라미터 사용하고자 할때
	public ResponseEntity<ArrayList<ReplyDTO>> getList(@PathVariable int bno){
		System.out.println(bno);
		rservice.list(bno);         //위의 배열 과 타입을 맞춰준다
		return new ResponseEntity<>(rservice.list(bno),HttpStatus.OK);									
	}
	//댓글수정을 하기위해 댓글내용 가져오기
	@GetMapping(value="{rno}", produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	
	public ResponseEntity<ReplyDTO> getDetail(@PathVariable int rno){// REST방식에서 주로 사용.URL경로의 일부를 파라미터 사용하고자 할때
		System.out.println(rno);
		return new ResponseEntity<>(rservice.detail(rno),HttpStatus.OK);	

	}
	@PutMapping(value="update",consumes="application/json", produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> update(@RequestBody ReplyDTO rdto){
		System.out.println("rdto="+rdto);		  	
		return rservice.update(rdto)==1?new ResponseEntity<>("success",HttpStatus.OK)			 // insert가 정상적으로 처리가 되었을떄
										:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // update가 비정상적으로 처리가 되었을떄
	}
	@DeleteMapping(value="remove",consumes="application/json", produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@RequestBody ReplyDTO rdto){
		System.out.println("rdto="+rdto);	
		return rservice.remove(rdto)==1?new ResponseEntity<>("success",HttpStatus.OK)			 // insert가 정상적으로 처리가 되었을떄
										:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // update가 비정상적으로 처리가 되었을떄
	
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	