<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>등록 정보 확인하기</h1>
<table border="1">
<tr>
	<th>순서</th>
	<th>State</th>
	<th>Name</th>
	<th>age</th>
	<th>addr</th>
</tr>
<c:forEach items="${memberList.list}" var="memberList" varStatus="s">
	<tr>
	<td>${s.count }</td>
	<td>${memberList.state }</td>
	<td>${memberList.name }</td>
	<td>${memberList.age }</td>
	<td>${memberList.addr }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>