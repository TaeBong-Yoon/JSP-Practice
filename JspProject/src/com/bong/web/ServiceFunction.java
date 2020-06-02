package com.bong.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//38강
//Service() : 서비스 함수
@WebServlet("/service-function")
public class ServiceFunction extends HttpServlet{

//	get, post를 명확하게 나눠써 쓴다면 메소드 사용.
//	doGet, doPost를 사용함으로써 아래는 필요가 없어진다.
	
//	하지만 get,post 둘다 사용한다면 아래처럼 service를 override해서 사용하는 것이 좋다!
	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		if(req.getMethod().equals("GET")) {
//			System.out.println("GET callesd");
//		} else if(req.getMethod().equals("POST")) {
//			System.out.println("POST called");
//		}
//		super.service(req, resp); //doGet, doPost
//	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGET Method called");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPOST Method called");
	}
}
