<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 47강 MVC model 2  EL(Expression Language) -->
<!-- 48강 EL의 데이터 저장소 -->
<!-- page -> request -> session -> application -->
<!-- Scope의 사용법 -->
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
	${header.accept}
</body>
</html>