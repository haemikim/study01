package org.huggies.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HuggiesController {
	private static final Logger logger = LoggerFactory.getLogger(HuggiesController.class);

	@RequestMapping(value = "board/board_list", method = RequestMethod.GET)
	public void board_list() {}

	
//	@RequestMapping(value = "board/board_list", method = RequestMethod.GET)
//	public String board_list() {
//		return "board_list";
//	}
	//void value값이 파일명/주소로 인식
	//return이 있으면 value값이 그냥 주소로 인식되어서 
	//board라는 파일에 담아서 사용중이니 void를 사용하여 추가 루트를 작성한다.
}
                                                       