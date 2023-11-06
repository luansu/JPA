package luansu.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import luansu.entity.Category;
import luansu.models.ProductModels;
import luansu.services.CategoryServiceImp;
import luansu.services.ICategoryService;
import luansu.services.IProductService;
import luansu.services.ProductServiceImp;
import utils.Constant;
import utils.UploadUtils;

@MultipartConfig(fileSizeThreshold = 1024*1024*10, maxFileSize = 1024*1024*50, maxRequestSize = 1024*1024*50)
@WebServlet(urlPatterns = {"/user-product/listProduct", "/user-product/delete", "/user-product/update", "/user-product/addproduct"})
public class ProductControllers extends HttpServlet {
	IProductService proService = new ProductServiceImp();
	ICategoryService cateService = new CategoryServiceImp();
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		
		if(url.contains("user-product/listProduct")) {
			findAll(req,resp);
		}
		else if(url.contains("user-product/delete")) {
			delete(req,resp);
			findAll(req,resp);
		}
		else if(url.contains("user-product/update")) {
			int productID = Integer.valueOf(req.getParameter("id"));
			ProductModels product = proService.findOne(productID);
			List<Category> listCate = cateService.findAll();
			
			req.setAttribute("listCate", listCate);
			req.setAttribute("product", product);

			RequestDispatcher rd = req.getRequestDispatcher("/views/product/updateProduct.jsp");
			rd.forward(req, resp);
		}
		else if(url.contains("user-product/addproduct")) {
			List<Category> listCate = cateService.findAll();
			
			req.setAttribute("listCate", listCate);
			RequestDispatcher rd = req.getRequestDispatcher("/views/product/addProduct.jsp");
			rd.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if(url.contains("user-product/update")) {
			update(req,resp);
			
		}
		else if(url.contains("user-product/addproduct")) {
			insert(req,resp);
		}
		findAll(req,resp);
	}
	
	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		List<ProductModels> listProd = proService.findAll();
		req.setAttribute("list", listProd);
		RequestDispatcher rd = req.getRequestDispatcher("/views/product/listProduct.jsp");
		rd.forward(req, resp);
	}
	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8"); 
		resp.setCharacterEncoding("UTF-8");
	 
	 
		ProductModels product = new ProductModels();
		
		try { 
			BeanUtils.populate(product, req.getParameterMap()); 
		
			proService.update(product);
		} catch(Exception e) { 
			e.printStackTrace(); 
		}
		 
	}
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int prodID = Integer.valueOf(req.getParameter("id"));
		proService.delete(prodID);
		 
	}
	private void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ProductModels product = new ProductModels();
		try { 	
			BeanUtils.populate(product, req.getParameterMap()); 
			if(req.getPart("imageLink").getSize()!=0) {
				String fileName = "" + System.currentTimeMillis();
				product.setImageLink(UploadUtils.processUpload("imageLink", req, Constant.DIR + "\\product\\", fileName));
			}
			product.setCategory(cateService.findOne(product.getCategoryID()));
			
			proService.insert(product);
			
			req.setAttribute("product", product);
			req.setAttribute("message", "Add successful");
		} catch(Exception e) { 
			e.printStackTrace(); 
			req.setAttribute("message", "Add fail");
		}
		
	}
}
