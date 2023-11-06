package hcmute.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.models.BooksModels;

import hcmute.services.BooksServiceImpl;
import hcmute.services.IBooksService;

@WebServlet(urlPatterns = { "/admin-listbooks", "/admin-addbooks", "/admin-updatebooks", "/admin-deletebooks", "/bookByAuthor", "/admin-rating" })
public class BooksController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IBooksService bookService = new BooksServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();

		if (url.contains("admin-listbooks")) {
			findAll(req, resp);
		} else if (url.contains("addbooks")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/books/addBooks.jsp");
			rd.forward(req, resp);
		} else if (url.contains("updatebooks")) {
			int id =Integer.parseInt(req.getParameter("id"));

			BooksModels model = bookService.findOne(id);
			req.setAttribute("book", model);

			RequestDispatcher rd = req.getRequestDispatcher("/views/books/updateBooks.jsp");
			rd.forward(req, resp);
		} else if (url.contains("deletebooks")) { 
			delete(req, resp); 
		} else if(url.contains("bookByAuthor")){
			int id = Integer.parseInt(req.getParameter("idAuthor"));
			List<BooksModels> listbook = bookService.getListBookByAuthorID(id);
			req.setAttribute("list", listbook);
			req.getRequestDispatcher("/views/books/listBooks.jsp").forward(req, resp);
		}else if(url.contains("rating")) {
			List<BooksModels> listbook = bookService.getListBookByRatingScore();
			
			req.setAttribute("list", listbook);
			req.getRequestDispatcher("/views/books/bookRating.jsp").forward(req, resp);
		}else if(url.contains("login")) {
			req.getRequestDispatcher("/decorators/login.jsp").forward(req, resp);
		}	 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String url = req.getRequestURI().toString();
		if (url.contains("addbooks")) {
			insert(req, resp);
		}
		else if(url.contains("updatebooks")) { 
			update(req,resp); 
		}
	}

	public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
		req.getRequestDispatcher("/views/books/listBooks.jsp").forward(req, resp);
	}
	private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// thiết lập ngôn ngữ tiếng việt
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		int isbn = Integer.parseInt(req.getParameter("isbn"));
		String title = req.getParameter("title");
		String publisher = req.getParameter("publisher");
		float price = Float.parseFloat(req.getParameter("price"));
		String description = req.getParameter("description");
		Date publish_date = Date.valueOf(req.getParameter("publish_date"));
		String cover_image = req.getParameter("cover_image");
		int quantity = Integer.parseInt(req.getParameter("quantity"));

		BooksModels book = new BooksModels();

		book.setIsbn(isbn);
		book.setTitle(title);
		book.setPublisher(publisher);
		book.setPrice(price);
		book.setDescription(description);
		book.setPublish_date(publish_date);
		book.setCover_image(cover_image);
		book.setQuantity(quantity);

		bookService.insert(book);

		resp.sendRedirect(req.getContextPath() + "/admin-listbooks");
	}
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// thiết lập ngôn ngữ tiếng việt
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		// nhận dữ liệu từ view
		int id = Integer.parseInt(req.getParameter("id"));

		// gọi phương thức finOne trong service
		bookService.delete(id);
		resp.sendRedirect(req.getContextPath()+"/admin-listbooks");
	}
	
	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		BooksModels book = new BooksModels();
		
		try {
			// Chuyển dữ liệu từ view sang model bằng Beanutils
			BeanUtils.populate(book, req.getParameterMap());
			bookService.update(book);
			req.setAttribute("message", "Sửa thành công");
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Sửa thất bại");
		}
		
		bookService.update(book);
		
		resp.sendRedirect(req.getContextPath() + "/admin-listbooks");
	}

}
