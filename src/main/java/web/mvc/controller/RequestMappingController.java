package web.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/first")
public class RequestMappingController {
	/**
	 * 리턴타입 String: 리턴 되는 문자열이 뷰의 이름이 된다.
	 * */
	@RequestMapping("a.do")
	public String firstTest() {
		System.out.println("first/a.do요청.........");
		return "first/a"; //WEB-INF/views/first/a.jsp이동
	}
	
	/**
	 * b.do 또는 c.do 요청이 하나의 메서드를 실행
	 * 리턴타입이 void인 경우: 요청된 주소가 view의 이름이 된다. ex:first/a.do가 요청되면 view의 이름은 first/a가 된다.=>최종 뷰정보/WEB-INF/views/first/a.jsp
	 * */
	@RequestMapping(value= {"/b.do", "/c.do"})
	public void bc() {
		System.out.println("first/b.do 또는 first/c.do 요청.......");
	}
	
	//아래와 같이 Get이나 Post방식에 따라 mapping해주면 맞지 않는 리퀘스트 요청시 405서버 에러가 발생한다.
	
//	@RequestMapping(value="/test.do", method = RequestMethod.GET)
	//버전 4.3이후부터는 아래 어노테이션 사용 가능
	@GetMapping("/test.do")
	public String testGet(HttpServletRequest req) {
		String name = req.getParameter("name");
		System.out.println("/test.do요청.......get방식...name: "+name);
		return "result";//WEB-INF/views/result.jsp
	}
	
	@PostMapping("/test.do")
	public String testPost(String name) {//requestMapping.html의 이름<input type="text" name="name"/> 을 받음
		System.out.println("/test.do 요청........post방식.....name:"+name);
		return "result";
		
	}
	
	/**
	 * parameter 정보에 따라 실행되는 메서드를 다르게
	 * */
//	@RequestMapping(value="/a.do", params= {"id"})
//	@RequestMapping(value="/a.do", params={"id=donald trump"})
	@RequestMapping(value="/a.do", params= {"id!=donald trump"})
	public ModelAndView aaa() {
		System.out.println("params정보로  test............");
		return new ModelAndView("result");
	}
}
