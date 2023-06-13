package com.study.springboot.config;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/*" })
public class MyFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		
		long start = System.currentTimeMillis();
		System.out.println("start : " + start);
		
		
		System.out.println("Filter 동작");

		// 인코딩 관리
		request.setCharacterEncoding("utf-8");

		// 파라메터
		String title = request.getParameter("title");
		System.out.println("title : " + title);

		// 세션 관리
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession();

		StringBuffer sb = httpReq.getRequestURL();
		String url = sb.toString();

		System.out.println("url : " + url);

		try {
			Boolean isLogon = (Boolean) session.getAttribute("isLogon");
			System.out.println("isLogon : " + isLogon);

			if (url.indexOf("/login") != -1
					|| url.indexOf("logout") != -1) {
			// 세션없이 통과	
				chain.doFilter(request, response);

			} else {
				if (isLogon == null || isLogon != true) {
					// 로그인 페이지로 이동
					HttpServletResponse resp = (HttpServletResponse) response;
					resp.sendRedirect("/login");
				} else {
					chain.doFilter(request, response);
				}
			}

		} catch (Exception e) {
			System.out.println("boolean에 null이 들어가면 예외");
			e.printStackTrace();
		}

		/*
		 * System.out.println("---------------------");
		 * 
		 * // 여기까지 들어오는 영역
		 * 
		 * // 마침내 Controller까지 보내기 사작 chain.doFilter(request, response);
		 * 
		 * // 밖으로 나가지 직전 영역 System.out.println("Filter 동작 완료");
		 * 
		 */
		
		long end = System.currentTimeMillis();
		System.out.println("걸린시간 : " + (end - start) + "[ms]");

	}

}
