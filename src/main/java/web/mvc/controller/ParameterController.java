package web.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mvc.model.dto.Member;

@Controller
@RequestMapping("/param")
public class ParameterController {

	/**
	 * 매개변수로 전달받은 Model객체는 뷰쪽으로 전달될 객체
	 * 매개변수 model에 정보를 저장하면 뷰에서 사용가능
	 * */
	@RequestMapping("/a.do")
	public String a(String name, Integer age, Model model) {//두번째 인수에서 int일경우 null값이 들어올때 서버 500에러가 발생해서 integer로 형변환해줌
		System.out.println(name+" , "+age);
		model.addAttribute("msg", "나훈아 디너쇼");
		return "result";
		
	}
	/**
	 * void는 뷰의 정보가 WEB-INF/views/param/c.jsp로 이동한다는 뜻
	 * parameter로 전달되는 name과 동일한 속성들을 가지고 있는 객체를 인수로 선언하면 그 객체를 생성해서 set메서드로 데이터를 저장해준다.
	 * 
	 * parameter로 전달된 정보를 객체로 바인딩하면 그 객체를 뷰에 가서 그대로 사용할 수 있다. -model정보에 저장이 된다.
	 * 사용방법은 뷰에서 사용할때 객체이름의 첫글자를 소문자로 변경해서 하면 된다.
	 * Member면 member로 사용한다. ${member.id}
	 * */
	
/*	@PostMapping("/c.do")
	public void c(Member member) {
		System.out.println("===============");
		System.out.println(member.getId());
		System.out.println(member.getAge());
		System.out.println(member.getAddr());
		System.out.println(member.getName());
	}*/
	
	//view에서 사용할때 model정보에 저장된 값을 꺼낼떄 modelAttribute를 통해서 이름을 변경할 수 있다.
	//ALIAS를 준다고 생각하면 된다
	@PostMapping("/c.do")
	public void c(@ModelAttribute("m") Member member) {
		System.out.println("===============");
		System.out.println(member.getId());
		System.out.println(member.getAge());
		System.out.println(member.getAddr());
		System.out.println(member.getName());
	}
	
	@ModelAttribute("hobbys")//뷰에서 ${hobby} 사용할 수 있다. ParameterController를 들렀다가 이동하는 view들만 정보를 사용가능하다.
	public List<String> hobbys(){
		List<String> list = new ArrayList();
		list.add("발레");
		list.add("영화보기");
		list.add("독서");
		list.add("와인");
		return list;
	}
	
	@ModelAttribute("addr")
	public String addr() {
		return "강남구";
	}
	
	/**
	 * parameter로 넘어오는 name과 매개변수의 이름이 다를때
	 * @RequestParam을 사용해서 매필해 줄 수 있다.
	 * @RequestParam을 선언하면 required="true"로 값이 반드시 들어와야 한다.=>값이 들어올 수도 있고 안들어올 수도 있으면
	 * required=false로 써주거나 defaultValue를 잡아준다.
	 * */
	@RequestMapping("/c.do")
	public String dd(@RequestParam(value="id", defaultValue="Guest")String userId,
			@RequestParam(value="name", required=false) String userName,
			@RequestParam(defaultValue="0")int age) {
		System.out.println("html과 메서드명 비동일"+userId);
		System.out.println("userName:"+userName);
		System.out.println("age:"+age);
		
		return "result";
	}
}
