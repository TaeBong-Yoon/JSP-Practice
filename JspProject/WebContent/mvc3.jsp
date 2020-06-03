<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 47강 MVC model 2  EL(Expression Language) -->
<!-- 48강 EL의 데이터 저장소 -->
<!-- page -> request -> session -> application -->
<!-- Scope의 사용법 -->
<!-- 49강 EL의 연산자 -->
<!-- View -->
<%
pageContext.setAttribute("result","hello!");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${requestScope.result}입니다.<br >
	${names[0]}<br >
	${names[1]}<br >
	${notice.title}<br >
	${result}<br >
	${param.n}<br >
	${header.accept}<br >
	${param.n > 3}<br >
	${param.n ge 3}<br > <!-- 49강 EL연산자 참조 >= 와 같다 -->
	${empty param.n}<br > <!-- pram.n == null || param.n == '' 와 같다 -->
	${empty param.n? 'n=empty' : param.n}<br >
	
	${param.n / 2}<br >
</body>
</html>