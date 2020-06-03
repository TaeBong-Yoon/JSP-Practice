package com.bong.web;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//강의 34강
//Servlet으로 동적인 페이지 만들기(계산기)

@WebServlet("/calc3")
public class Calc3 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();

		String value = request.getParameter("value");
		String operator = request.getParameter("operator");
		String dot = request.getParameter("dot");

		String exp = "";
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("expression")) {
					exp = c.getValue();
					break;
				}
			}
		}

		if (operator != null && operator.equals("=")) {
//			ScriptEngine : 자바에서 스크립트를 실행할 수 있는 라이브러리
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				e.printStackTrace();
			}

		} else if (operator != null && operator.equals("C")) {
//			강의 35강 - 쿠키 삭제하기
			exp = "";
		} else {
			exp += (value == null) ? "" : value; // value값이 null이 아니면 누적
			exp += (operator == null) ? "" : operator; // 셋 중에 하나만 누적해준다.
			exp += (dot == null) ? "" : dot;
		}

		Cookie expCookie = new Cookie("expression", exp);
		if (operator != null && operator.equals("C")) {
			expCookie.setMaxAge(0);// 쿠키가 남지않고 바로 삭제됨.
		}
		
		response.addCookie(expCookie);

		response.sendRedirect("/calc3-page");

	}

}
