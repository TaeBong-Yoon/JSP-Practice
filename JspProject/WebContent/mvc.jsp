<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 44강 지양해야할 복잡한 코드(스파게티 코드) -->
<!-- 45강 mvc2에서 깔끔하게 정리해보기 -->
<%
int num = 0;
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
String num_ = request.getParameter("n");

if(num_ != null && !num_.equals("")){
	num = Integer.parseInt(num_);
}
%>
<body>
<% if(num%2 != 0){ %>
홀수입니다. ODD
<%
} else {
%>
짝수입니다. EVEN
<% } %>
</body>
</html>