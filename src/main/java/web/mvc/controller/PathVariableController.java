package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathVariableController {
	@RequestMapping(value="/{type}/{test}.do")
	public String aa(@PathVariable String type, @PathVariable String test) {//type=값&test=값
		System.out.println("/{type}/{test}.do가 요청.........");
		System.out.println("type="+type);
		System.out.println("test="+test);
		
		return "result";
	}
	
	//web.xml의 servletmapping <url-pattern>/blog/*</url-pattern>
	//여기에서 *에 해당하는 것만 세팅한다
	@RequestMapping(value="{path}")
	public String path(@PathVariable String path) {
		System.out.println("blog/{path}요청.......");
		System.out.println("path="+path);
		
		return "result";
	}
	
	@RequestMapping(value="/{board}/{qna}/{no}")
	public String aa(@PathVariable String board, @PathVariable String qna,@PathVariable int no) {
		System.out.println("blog/{board}/{qna}/{no}요청.....");
		System.out.println("board="+board);
		System.out.println("qna="+qna);
		System.out.println("no="+no);
		
		return "result";
	}
	
	//모든 요청을 한꺼번에 여기로 *.do 받을 수 있고 void이기 때문에 들어오는 페이지명으로 이동한다.
	@RequestMapping("{url}.do")
	public void aaa() {
		System.out.println("{url}.do.........");
	}
}
