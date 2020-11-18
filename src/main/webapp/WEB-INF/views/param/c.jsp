<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Member 객체 사용하기</h1>
<h3>id:${member.id }
	age:${member.age }
	name:${member.name }
	addr:${member.addr }
</h3>

<h1>@ModelAttribute("m")을 사용하기</h1>
<h3>id:${m.id }
	age:${m.age }
	name:${m.name }
	addr:${m.addr }
</h3>

<c:forEach items="${hobbys }" var="h">
	<input type="checkbox" value="${h }"/>${h }
</c:forEach>

<hr>
주소:${addr }
</body>
</html>