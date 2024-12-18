package com.cia103g5.member.controller;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cia103g5.member.model.Member_info;
import com.cia103g5.member.service.Member_infoService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/frontend/member/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Member_infoService memberInfoService = new Member_infoService();

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");

		String account = req.getParameter("account");
		String password = req.getParameter("password");

		if (account == null || password == null || account.isEmpty() || password.isEmpty()) {
			req.setAttribute("errorMessage", "帳號或密碼不能為空");
			req.getRequestDispatcher("/frontend/member/login.jsp").forward(req, res);
			return;
		}

		try {

			Member_info member = memberInfoService.login(account, password);
			HttpSession session = req.getSession();	
			
			if(member.getPhoto() != null) {
				String base64Photo = Base64.getEncoder().encodeToString(member.getPhoto());
				session.setAttribute("photo", base64Photo);
			}
			
			session.setAttribute("member", member);
			req.setAttribute("successMessage", "登入成功！即將跳轉頁面。");
			res.sendRedirect(req.getContextPath() + "/frontend/member/membercenter_el.jsp");
			// 或是跳轉到原先畫面

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMessage", "帳號或密碼錯誤");
			req.getRequestDispatcher("/frontend/member/login.jsp").forward(req, res);
		}
	}
}
