package web.mvc.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@RequestMapping("/test.do")
	public String aa(String no) {
		int convertNo = Integer.parseInt(no);
		return "result";
	}
	
	@RequestMapping("test/a.do")
	public String a(String id) {
		System.out.println("id="+id);
		
		//redirect:를 쓰면 요청이 하나의 controller를 실행한다. index.do를 매핑한 StartController가 실행됨
		return "redirect:/index.do";
	}
	
	@RequestMapping("test/b.do")
	public ModelAndView b(String id, HttpServletRequest req, HttpSession session) {
		ServletContext context = session.getServletContext(); 
		
		System.out.println("/test/b.do실행...........");
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("forward:/index.do");
		return mv;
	}
}
