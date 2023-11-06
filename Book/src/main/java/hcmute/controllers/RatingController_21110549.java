package hcmute.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.Services.AuthorServiceImpl_21110549;
import hcmute.Services.BookServiceImpl_21110549;
import hcmute.Services.IAuthorService_21110549;
import hcmute.Services.IBookService_21110549;
import hcmute.Services.IRatingService_21110549;
import hcmute.Services.RatingServiceImpl_21110549;
import hcmute.models.AuthorModel_21110549;
import hcmute.models.BookModel_21110549;
import hcmute.models.RatingModels_21110549;

@WebServlet (urlPatterns = {"/admin-book/ratingByBookID"})
public class RatingController_21110549 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	IRatingService_21110549 ratingService = new RatingServiceImpl_21110549();
	IAuthorService_21110549 authorService = new AuthorServiceImpl_21110549();
	IBookService_21110549 bookService = new BookServiceImpl_21110549();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		
		if (url.contains("ratingByBookID")) {
			getRatingByBookID(req, resp);
		}
	}

	private void getRatingByBookID(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		int count = ratingService.countRatingByBookID(id);
		
		AuthorModel_21110549 author = authorService.authorByBookID(id);
		BookModel_21110549 book = bookService.findOne(id);
		
		
		req.setAttribute("count", count);
		req.setAttribute("author", author);
		req.setAttribute("book", book);
		req.getRequestDispatcher("/views/admin/listbook.jsp").forward(req, resp);
	}
}
