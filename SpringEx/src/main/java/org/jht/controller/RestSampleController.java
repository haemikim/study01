package org.jht.controller;
import org.jht.domain.RestSampleDTO;
import org.springframework.http.MediaType;
//JSON타입을 사용하여보자~
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("sample")
public class RestSampleController {    // 일밤적으론 html로 구성되는데 plain은  그냥 return값을 뿌리는 형태
	// 단순문자열을 반환
	@GetMapping(value="getText" ,produces="text/plain; charset=UTF-8")
		public String getText() {
			return "안녕하세요";
		}
	// 객체 반환                                                      		// 두가지 형식으로 보고싶으면 중괄호를 사용(하나는 아무것도 사용안함)
	@GetMapping(value="getSample" ,produces= {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_RSS_XML_VALUE})
		public RestSampleDTO getSample() {
		// RestSampleDTO rs = new RestSampleDTO(100,"정","자바");
		// return rs;
		return new RestSampleDTO(100,"정","자바");  
	}
	
	
}

