package hcmute.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.services.AuthorServiceImpl;
import hcmute.services.IAuthorService;
import hcmute.models.AuthorModels;

@WebServlet (urlPatterns = {"/author/listauthors"})
public class AuthorController extends HttpServlet{

	IAuthorService authorService = new AuthorServiceImpl();
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		
		if (url.contains("listauthors")) {
			findAll(req, resp);
		}
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<AuthorModels> listAuthors = authorService.findAll();
		
		req.setAttribute("listauthors", listAuthors);
		req.getRequestDispatcher("/views/author/listAuthor.jsp").forward(req, resp);
		
	}
	
	
}