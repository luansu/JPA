package hcmute.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.Services.AuthorServiceImpl_21110549;
import hcmute.Services.IAuthorService_21110549;
import hcmute.models.AuthorModel_21110549;

@WebServlet (urlPatterns = {"/admin-author/listAuthor", "/admin-author/add", "/admin-author/update", "/admin-author/delete"})
public class AuthorController_21110549 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	IAuthorService_21110549 authorService = new AuthorServiceImpl_21110549();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		
		if (url.contains("listAuthor")) {
			List<AuthorModel_21110549> list = authorService.findAll();
			
			req.setAttribute("list", list);
			req.getRequestDispatcher("/views/admin/listAuthor.jsp").forward(req, resp);
		} else if (url.contains("add")) {
			req.getRequestDispatcher("/views/admin/insertAuthor.jsp").forward(req, resp);
		} else if (url.contains("update")) {
			
			int id = Integer.parseInt(req.getParameter("id"));
			AuthorModel_21110549 author = authorService.findOne(id);
			req.setAttribute("author", author);
			req.getRequestDispatcher("/views/admin/updateAuthor.jsp").forward(req, resp);
			
		} else if (url.contains("delete")) {

			int id = Integer.parseInt(req.getParameter("id"));
			AuthorModel_21110549 author = authorService.findOne(id);
			authorService.delete(author);
			resp.sendRedirect(req.getContextPath() + "/admin-author/listAuthor");
		} 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		
		if (url.contains("add")) {
			String authorName = req.getParameter("authorname");
			Date date = Date.valueOf(req.getParameter("date_of_birth"));
			
			AuthorModel_21110549 author = new AuthorModel_21110549();
			author.setAuthorname(authorName);
			author.setDate_of_birth(date);
			
			authorService.insert(author);
			resp.sendRedirect(req.getContextPath() + "/admin-author/listAuthor");
		} else if (url.contains("update")) {
			
			String authorName = req.getParameter("authorname");
			Date date = Date.valueOf(req.getParameter("date_of_birth"));
			
			AuthorModel_21110549 author = new AuthorModel_21110549();
			author.setAuthorname(authorName);
			author.setDate_of_birth(date);
			
			authorService.update(author);
			resp.sendRedirect(req.getContextPath() + "/admin-author/listAuthor");
		}
	}
}
