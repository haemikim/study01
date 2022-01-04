package org.huggies.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HuggiesController {
	private static final Logger logger = LoggerFactory.getLogger(HuggiesController.class);

	@RequestMapping(value = "Huggies/board_list", method = RequestMethod.GET)
	public String board_list() {
		return "board_list";
	}
}
                                                       