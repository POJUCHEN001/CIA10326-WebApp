package com.cia103g5.member.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.cia103g5.member.model.Member_info;
import com.cia103g5.member.service.Member_infoService;

@WebServlet("/frontend/member/RegisterServlet")
@MultipartConfig(maxFileSize = 5 * 1024 * 1024)	// 在類別上添加 @MultipartConfig 註解，以確保能正確處理上傳檔案。並設置上傳檔案大小
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Member_infoService memberInfoService = new Member_infoService();

	public RegisterServlet() {
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
		String name = req.getParameter("name");
		String email = req.getParameter("email");

//		Integer gender = Integer.parseInt(req.getParameter("gender"));
		
		Integer gender = null;
		if (req.getParameter("gender") != null && !req.getParameter("gender").isEmpty()) {
			gender = Integer.parseInt(req.getParameter("gender"));
		}
		
		Part photo = req.getPart("photo");
		byte[] photoBytes = null;
		if (photo != null && photo.getSize() > 0) {
			try (InputStream is = photo.getInputStream()) {
				photoBytes = is.readAllBytes();
			}
		}

		Member_info newMember = new Member_info();
		newMember.setAccount(account);
		newMember.setPassword(password);
		newMember.setName(name);
		newMember.setEmail(email);
		newMember.setGender(gender);
		newMember.setPhoto(photoBytes);

		
		try {
			memberInfoService.registerMember(newMember);
			req.setAttribute("successMessage", "註冊成功！請前往登入。");
			req.getRequestDispatcher("/frontend/member/login.jsp").forward(req, res); // 重定向到登入頁面
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMessage", e.getMessage());  // 傳遞具體的錯誤訊息
			req.getRequestDispatcher("/frontend/member/regist.jsp").forward(req, res);
		}

	}

}
