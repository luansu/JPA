package hcmute.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hcmute.entity.*;
import hcmute.services.*;

@WebServlet(urlPatterns = {"/user/home", "/user/detail", "/user/add"})
public class HomeControllerUser extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	IBooksService booksService = new BooksServiceImp();
	IRatingService ratingService = new RatingServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if(url.contains("user/home")) {
			getBookInfo(req, resp);
		}else if(url.contains("user/detail")){
			getDetailBook(req, resp);
		} else if(url.contains("user/add")){
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if(url.contains("user/home")) {
			//getBookInfo(req, resp);
		}else if(url.contains("user/detail")){
			
			
		} else if(url.contains("user/add")){
			postReview(req, resp);
		}
	}
	
	protected void getDetailBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		
		Books book = booksService.findById(id);
		
		List<Rating> ratinglist = ratingService.findByBookId(id);
		
		HttpSession session = req.getSession(true);
		session.setAttribute("book", book);
		
		req.setAttribute("i", book);
		req.setAttribute("ratinglist", ratinglist);
		req.getRequestDispatcher("/views/user/bookrating.jsp").forward(req, resp);	
	}
	
	protected void getBookInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Books> listbooks = booksService.findAll();
		int pagesize = 1;
		int size = listbooks.size();
		int num = (size%pagesize==0 ? (size/pagesize) : (size/pagesize + 1));
		int page, numberpage = pagesize;
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
		
		List<Books> list = booksService.getListBookByPage(listbooks, start, end);
		req.setAttribute("list", list);
		req.setAttribute("page", page);
		req.setAttribute("num", num);
		req.getRequestDispatcher("/views/user/bookinfo.jsp").forward(req, resp);	
	}
	
	protected void postReview(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession(true);
		
		Users user = (Users)session.getAttribute("account");
		Books book = (Books)session.getAttribute("book");
		
		String review_text = req.getParameter("review_text");
		System.out.println(review_text);
		System.out.println(book);
		String rating = req.getParameter("rate");
		System.out.println(rating);
		
		RatingID ratingid = new RatingID(book.getBookid(), user.getId());
		Rating newrating = new Rating(ratingid, 3, review_text, book, user);
		ratingService.insert(newrating);
		
		req.setAttribute("id", book.getBookid());
		resp.sendRedirect(req.getContextPath() + "/user/home");
	}
}
