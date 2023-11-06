package luansu.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import luansu.entity.Category;
import luansu.services.CategoryServiceImp;
import luansu.services.ICategoryService;

@WebServlet(urlPatterns = {"/user-category/listCate", "/user-category/delete", "/user-category/update", "/user-category/addcate"})
public class CategoryControllers extends HttpServlet {
	ICategoryService cateService = new CategoryServiceImp();
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("user-category/listCate")) {
			findAll(req, resp);
		}
		else if(url.contains("user-category/delete")) {
			delete(req, resp);
		}
		else if(url.contains("user-category/addcate")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/category/addCategory.jsp");
			rd.forward(req, resp);
		}
		else if(url.contains("user-category/update")) {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");

			// nhận dữ liệu từ view
			int id = Integer.valueOf(req.getParameter("id"));

			// gọi phương thức finOne trong service
			Category category = cateService.findOne(id);

			// đẩy dữ liệu ra view
			req.setAttribute("cate", category);

			RequestDispatcher rd = req.getRequestDispatcher("/views/category/updateCategory.jsp");
			rd.forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String url = req.getRequestURI().toString();
		if(url.contains("user-category/update")) {
			update(req, resp);
		}
		else if(url.contains("user-category/addcate")) {
			insert(req, resp);
		}
		findAll(req, resp);
	}
	
	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		List<Category> listCate = cateService.findAll();
		
		req.setAttribute("list", listCate);
		RequestDispatcher rd = req.getRequestDispatcher("/views/category/listCategory.jsp");
		rd.forward(req, resp);
	}
	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		Category category = new Category();
		try {
			BeanUtils.populate(category, req.getParameterMap());
			cateService.update(category);
			
			req.setAttribute("category", category);
			req.setAttribute("message", "Update successful");
		} catch(Exception e) { 
			e.printStackTrace(); 
			req.setAttribute("message", "Update fail");
		}
	}
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		try {
			int cateID = Integer.valueOf(req.getParameter("id"));
			cateService.delete(cateID);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("Error", "Error" + e.getMessage());
		}
		findAll(req, resp);
	}
	private void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		Category category = new Category();
		try {
			BeanUtils.populate(category, req.getParameterMap());
			cateService.insert(category);
			
			req.setAttribute("category", category);
			req.setAttribute("message", "Add successful");
		} catch(Exception e) { 
			e.printStackTrace(); 
			req.setAttribute("message", "Add fail");
		}
	}
}
