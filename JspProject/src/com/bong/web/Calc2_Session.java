package com.bong.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//강의 27강,28강 - Session
//Session 객체로 상태 값 저장

//session : 현재 접속자(브라우저)
//다른 브라우저에는 저장이 되지 않는다. (다른 사용자로 인식됨 = 세션이 다름)

//void setAttribute(String name,Object value) : 지정된 이름으로 객체를 설정
//Object getAttribute(String name) : 지정한 이름의 객체를 반환
//void invalidate() : 세션에서 사용되는 객체들을 바로 해제

//void setMaxInactiveInterval(int interval) : 세션 타임아웃을 정수(초)로 설정
//boolean isNew() : 세션이 새로 생성되었는지를 확인
//Long getCreationTime() : 세션이 시작된 시간을 반환, 밀리초 단위
//long getLastAccessedTime() : 마지막 요청 시간, 밀리초 단위

@WebServlet("/calc2-session")
public class Calc2_Session extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");

		int v = 0;

		if (!v_.equals("")) {
			v = Integer.parseInt(v_);
		}
//		값을 계산해줌. +,-
		if (op.equals("=")) {

			int x = (Integer) session.getAttribute("value");// Object로 오기때문에 Integer
			int y = v;
			String operator = (String) session.getAttribute("op");

			int result = 0;

			if (operator.equals("+")) {
				result = x + y;
			}
			if (operator.equals("-")) {
				result = x - y;
			}
			response.getWriter().printf("result is %d\n", result);
		} else {
//		값을 저장해줌. = 
			session.setAttribute("value", v);
			session.setAttribute("op", op);
		}

	}

}
