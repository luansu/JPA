package hcmute.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.entity.*;
import hcmute.services.*;

@WebServlet(urlPatterns = {"/user/home"})
public class HomeControllerUser extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	IBooksService booksService = new BooksServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getBookInfo(req, resp);	
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
}
