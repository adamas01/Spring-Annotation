package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {

	@RequestMapping("/exception.do")
	public ModelAndView aa(String no) {
//		int convertNo = Integer.parseInt(no);
//		int re = 100/convertNo;
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "예외 없이 동작완료함");
		mv.setViewName("result");
		return mv;
	}
	/**
	 * 현재 Controller에서 발생하는 예외를 처리할 메서드를 작성
	 * */
	@ExceptionHandler(value = {NumberFormatException.class, ArithmeticException.class})
	public ModelAndView exception(Exception e) {
		System.out.println("ExceptionHandler 실행.........");
		ModelAndView mv = new ModelAndView();
		mv.addObject("errClass", e.getClass());
		mv.addObject("errMsg", e.getMessage()+"가 발생함");
		
		mv.setViewName("error/errorView");
		return mv;
	}
}
