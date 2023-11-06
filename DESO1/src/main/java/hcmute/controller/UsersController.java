package hcmute.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.services.IRatingService;
import hcmute.services.IUsersService;
import hcmute.services.RatingServiceImpl;
import hcmute.services.UsersServiceImpl;
import hcmute.models.RatingModels;
import hcmute.models.UsersModels;


@WebServlet(urlPatterns = {"/listuser", "/ratingByUser"})
public class UsersController extends HttpServlet{
	
	IUsersService userService = new UsersServiceImpl();
	IRatingService ratingService = new RatingServiceImpl();
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		
		if (url.contains("listuser")) {
			doGet_FindAll(req,resp);
		}else if (url.contains("ratingByUser")) {
			doGet_RatingByUser(req,resp);
		}
	}

	private void doGet_RatingByUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		List<RatingModels> rating = ratingService.listRatingbyID(id);
		req.setAttribute("listrating", rating);
		
		UsersModels user = userService.findInfor(id);
		req.setAttribute("user", user);
		
		req.getRequestDispatcher("/views/rating/ratingByUser.jsp").forward(req, resp);
		
	}

	private void doGet_FindAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<UsersModels> listuser = userService.findAll();
		
		req.setAttribute("listuser", listuser);
		req.getRequestDispatcher("/views/user/listuser.jsp").forward(req, resp);
	}
}