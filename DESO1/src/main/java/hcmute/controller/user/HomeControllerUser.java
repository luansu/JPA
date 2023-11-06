package hcmute.controller.user;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.DAO.IUsersDAO;
import hcmute.models.BooksModels;
import hcmute.models.UsersModels;
import hcmute.services.BooksServiceImpl;
import hcmute.services.IBooksService;
import hcmute.services.IUsersService;
import hcmute.services.UsersServiceImpl;
import hcmute.utils.Constant;

@WebServlet(urlPatterns = { "/home",  "/login", "/waiting", "/logout"})
public class HomeControllerUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IBooksService bookService = new BooksServiceImpl();
	IUsersService userService = new UsersServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if(url.contains("home")) {
			findAll(req,resp);
		}
		else if (url.contains("login")) {
			getLogin(req, resp);
		} else if (url.contains("waiting")) {
			getWaiting(req, resp);
		}else if (url.contains("logout")) {
			getLogout(req, resp);
		}
		
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BooksModels> listbooks = bookService.findAll();
		int size = listbooks.size();
		int num = (size%6==0 ? (size/6) : (size/6 + 1));
		int page, numberpage = 6;
		String xpage = req.getParameter("page");
		if (xpage == null) {
			page = 1;
		}
		else {
			page = Integer.parseInt(xpage);
		}
		int start,end;
		start = (page - 1) * numberpage;
		end = Math.min(page*numberpage, size);
		
		List<BooksModels> list = bookService.getListBookByPage(listbooks, start, end);
		
		req.setAttribute("list", list);
		req.setAttribute("page", page);
		req.setAttribute("num", num);
		req.getRequestDispatcher("/views/user/listBooks.jsp").forward(req, resp);
	}

	private void getLogout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession sesson = req.getSession();
		sesson.removeAttribute("account"); // remove session
		
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (Constant.COOKIE_REMEMBER.equals(cookie.getName())) {
					cookie.setMaxAge(0);// remove cookie
					resp.addCookie(cookie);
					break;
				}
			}
		}
		resp.sendRedirect("./login");
	}

	private void getWaiting(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("account") != null) {
			UsersModels user = (UsersModels) session.getAttribute("account");
			req.setAttribute("username", user.getUsername());
			if (user.isIs_admin()) {
				resp.sendRedirect(req.getContextPath() + "/admin-home");
			} else {
				resp.sendRedirect(req.getContextPath() + "/home");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("login")) {
			postLogin(req, resp);
		}
	}

	private void getLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// Check session
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath() + "/waiting");
			return;
		}

		// Check cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					session = req.getSession(true);
					session.setAttribute("username", cookie.getValue());
					resp.sendRedirect(req.getContextPath() + "/waiting");
					return;
				}
			}
		}

		req.getRequestDispatcher("/decorators/login.jsp").forward(req, resp);

	}

	private void postLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String passwd = req.getParameter("passwd");
		boolean isRememberMe = false;
		String remember = req.getParameter("remember");

		if ("on".equals(remember)) {
			isRememberMe = true;
		}

		String alertMsg = "";
		if (username.isEmpty() || passwd.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("error", alertMsg);
			req.getRequestDispatcher("/decorators/login.jsp").forward(req, resp);
			return;
		}

		UsersModels user = userService.login(username, passwd);
		if (user != null) {

			// Tao session
			HttpSession sesion = req.getSession(true);
			sesion.setAttribute("account", user);

			/*
			 * if (isRememberMe) {
			 * 
			 * }
			 */

			resp.sendRedirect(req.getContextPath() + "/waiting");
		} else {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("error", alertMsg);
			req.getRequestDispatcher("/decorators/login.jsp").forward(req, resp);
		}
	}
}
