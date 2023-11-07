package hcmute.controller.web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hcmute.services.*;
import hcmute.utils.Constant;
import hcmute.entity.*;

@WebServlet(urlPatterns = {"/login", "/waiting"})
public class HomeController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	IUsersService userService = new UsersServiceImp();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		
		if(url.contains("home")) {
			
		} else if(url.contains("login")) {
			getLogin(req, resp);
		} else if(url.contains("register")) {
			
		} else if(url.contains("waiting")) {
			getWaiting(req, resp);
		} else if(url.contains("verifyCode")) {
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();

		if(url.contains("home")) {
		
		} else if(url.contains("login")) {
			postLogin(req, resp);
		} else if(url.contains("register")) {
			
		} else if(url.contains("waiting")) {
			
		} else if(url.contains("verifyCode")) {
			
		}
	}
	
	protected void getLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath() + "/waiting");
		}
		
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("username")) {
					session = req.getSession(true);
					session.setAttribute("username", cookie.getValue());
					resp.sendRedirect(req.getContextPath() + "/waiting");
					return;
				}
			}
		}
		req.getRequestDispatcher("decorators/login.jsp").forward(req, resp);	
	}
	
	protected void postLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		
		String username = req.getParameter("username");
		String password = req.getParameter("passwd");
		boolean isRememberMe = false;
		String remember = req.getParameter("remembber");
		
		if("on".equals(remember)) {
			isRememberMe = true;
		}
		String alertMsg = "";
		
		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("error", alertMsg);
			req.getRequestDispatcher("decorators/login.jsp").forward(req, resp);
			return;
		}
		
		Users user = userService.login(username, password);
		if(user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
			if(isRememberMe) {
				saveRememberMe(resp, username);
			}
			
			resp.sendRedirect(req.getContextPath() + "/waiting");
		} else {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("error", alertMsg);
			req.getRequestDispatcher("decorators/login.jsp").forward(req, resp);
		}
	}
	
	protected void getWaiting(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session != null && session.getAttribute("account") != null) {
			Users u = (Users) session.getAttribute("account");
			req.setAttribute("username", u.getEmail());
			if (u.isIs_admin()) {
				resp.sendRedirect(req.getContextPath() + "/admin/home");
			} else {
				resp.sendRedirect(req.getContextPath() + "/user/home");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}
	
	private void saveRememberMe(HttpServletResponse resp, String username) {
		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
		cookie.setMaxAge(30*60);
		resp.addCookie(cookie);
	}
}
