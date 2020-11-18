package web.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//버전업되면서 4.0부터는 Controller와 responseBody를 합친 RestController 사용이 가능하다: 일반 요청은 받지 않고 비동기화통신만 가능

@RestController
public class ResponseBodyController {
	@RequestMapping(value="/responseBody.do", produces="text/html;charset=UTF-8")
	//@ResponseBody : 리턴되는 값이 그대로 응답객체가 된다. -ajax할때 필요
	public String aa() {
		return "ResponseTest";
	}
}
