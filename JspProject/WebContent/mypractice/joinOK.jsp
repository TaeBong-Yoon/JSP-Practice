<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.bong.web.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");
String password = request.getParameter("password");
String name = request.getParameter("name");
int age =Integer.parseInt(request.getParameter("age"));
String ip = request.getParameter("ip");

Connection conn = DBUtil.getMySQLConnection();//db

String sql = "INSERT INTO member(id,password,name,age,point,ip) VALUES(?,?,?,?,?,?)";
PreparedStatement pstmt = conn.prepareStatement(sql);

pstmt.setString(1, id);
pstmt.setString(2, password);
pstmt.setString(3, name);
pstmt.setInt(4, age);
pstmt.setInt(5, 0);
pstmt.setString(6, ip);
pstmt.executeUpdate();

DBUtil.close(pstmt);
DBUtil.close(conn);


%>

</body>
</html>