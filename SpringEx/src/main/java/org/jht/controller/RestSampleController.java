package org.jht.controller;
import org.jht.domain.RestSampleDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//JSON타입을 사용하여보자~
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	// 객체 반환                                                      		// 두가지 형식으로 보고싶으면 중괄호를 사용(하나는 아무것도 사용안함) JSON사용으로 한글깨짐 방지
	@GetMapping(value="getSample" ,produces= {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_RSS_XML_VALUE})
		public RestSampleDTO getSample() {
		// RestSampleDTO rs = new RestSampleDTO(100,"정","자바");
		// return rs;
		return new RestSampleDTO(100,"정","자바");  
	}
	// ResponseEntity타입 반환
	@GetMapping(value="check")
	public ResponseEntity<RestSampleDTO> check(int mno, String firstName, String lastName){// 값을 지어 넣어서 주소를 작성해준다
		// 사용자로부터  매니저번호를 받아서,
		RestSampleDTO rsdto = new RestSampleDTO(mno,firstName,lastName);
		ResponseEntity<RestSampleDTO> result=null;
		if(mno<150) { // 매니저 번호가 150 미만이면
		// 비정상으로 처리                              -status가 502 : BAD_GATEWAY
			result=ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(rsdto);
		}else {// 그렇지 않으면 
		// 정상으로 처리						-status가 200 : OK
			result=ResponseEntity.status(HttpStatus.OK).body(rsdto);
		}
		
		return result;
		
	}
	// 메소드의 매개변수
	// 객체타입을 매개변수로 지정해야되는 경우에는@RequestBody를 사용해냐됨
	@PostMapping("mno")				// 기존생성자를 필요로 함
	public RestSampleDTO mno(@RequestBody RestSampleDTO rsdto) {
		System.out.println("rsdto="+rsdto);
		return rsdto;
	}
	
	
}

