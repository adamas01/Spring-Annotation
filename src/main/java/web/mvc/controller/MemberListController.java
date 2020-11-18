package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.model.dto.Member;
import mvc.model.dto.MemberList;

@Controller
public class MemberListController {

		@RequestMapping("memberMulti.do")
		public void aa(MemberList memberList) {
			System.out.println("================");
			for(Member m:memberList.getList()) {
				System.out.println(m.isState());
				System.out.println(m.getAddr());
				System.out.println(m.getAge());
				System.out.println(m.getName());
			}
		}
}
