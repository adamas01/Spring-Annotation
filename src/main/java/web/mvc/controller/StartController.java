package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StartController {
	
	@RequestMapping("/index.do")
	public ModelAndView start() {
		System.out.println("index.do가 요청되어 start() 메서드 호출........");
		ModelAndView mv = new ModelAndView();
		
		//requestScope에 start()메서드 작동 msg저장
		mv.addObject("msg","start()메서드 작동.......");
		
		//WEB-INF/views/result.jsp로 보내기
		mv.setViewName("result");
		return mv;
	}
}
