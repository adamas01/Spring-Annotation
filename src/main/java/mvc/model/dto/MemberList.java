package mvc.model.dto;

import java.util.List;

public class MemberList {//변수명은 MemberListProperty.html과 동일하게 한다(<input type="checkbox" name="list[0].state"/>)
	
	private List<Member> list;

	public List<Member> getList() {
		return list;
	}

	public void setList(List<Member> list) {
		System.out.println("setList(List<Member> list)call.......list="+list+"\n");
		this.list = list;
	}
	
	
}
