package hcmute.controller.admin;

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
import hcmute.controller.BooksController;
import hcmute.models.BooksModels;
import hcmute.models.UsersModels;
import hcmute.services.BooksServiceImpl;
import hcmute.services.IBooksService;
import hcmute.services.IUsersService;
import hcmute.services.UsersServiceImpl;
import hcmute.utils.Constant;

@WebServlet(urlPatterns = { "/admin-home", "/admin-logout"})
public class HomeControllerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BooksController book = new BooksController();
	IUsersService userService = new UsersServiceImpl();
	IBooksService bookService = new BooksServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if(url.contains("home")) {
			book.findAll(req, resp);
		}else if (url.contains("logout")) {
				getLogout(req, resp);
		}else if(url.contains("bookbyauthor")) {
			
		}
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
	
}

