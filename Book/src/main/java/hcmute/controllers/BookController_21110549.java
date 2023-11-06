package hcmute.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import hcmute.Services.BookServiceImpl_21110549;
import hcmute.Services.IBookService_21110549;
import hcmute.models.AuthorModel_21110549;
import hcmute.models.BookModel_21110549;
import hcmute.Services.*;




@WebServlet (urlPatterns = {"/admin-book/home","/admin-book/list", "/admin-book/add", "/admin-book/update", "/admin-book/delete","/admin-book/listbookauthor","/admin-book/detail", "/admin-book/detailReviews"})

public class BookController_21110549 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	IBookService_21110549 bookService = new BookServiceImpl_21110549();
	IAuthorService_21110549 authorService = new AuthorServiceImpl_21110549();
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String url = req.getRequestURI().toString();
			if (url.contains("home")) {
				resp.setContentType("text/html");
				resp.setCharacterEncoding("UTF-8");
				req.setCharacterEncoding("UTF-8");
				
		        String indexPage = req.getParameter("index");
				
				List<BookModel_21110549> listvideo  = bookService.findAll();
				
				if (indexPage == null) {
					indexPage = "1";
				}
				int index = Integer.parseInt(indexPage);
				int count = listvideo.size();
				int endPage = (int) Math.ceil((double) count / 3);

				
				List<BookModel_21110549> listvideo1 = bookService.findAllPage(index);
				
				req.setAttribute("listbook", listvideo1);
				req.setAttribute("tag", indexPage);
				req.setAttribute("endP", endPage);
				req.getRequestDispatcher("/views/admin/listbook.jsp").forward(req, resp);
				
			}else if (url.contains("detailReviews")) {
				
				int id = Integer.parseInt(req.getParameter("id"));
				BookModel_21110549 book = bookService.findOneBookandAuthor(id);
				
				req.setAttribute("book", book);
				req.getRequestDispatcher("/views/admin/reviews.jsp").forward(req, resp);
			}
			
			else if (url.contains("list")) {
				List<BookModel_21110549> list = bookService.findAllBookandAuthorID();
				req.setAttribute("listbook", list);
				req.getRequestDispatcher("/views/admin/ratingByBookID.jsp").forward(req, resp);
			}
			
			else if (url.contains("add")) {
			   
			    RequestDispatcher rd = req.getRequestDispatcher("/views/admin/addbook.jsp");
			    rd.forward(req, resp);
			}else if (url.contains("delete")) {
				int id = Integer.parseInt(req.getParameter("id"));
			    try {
			        bookService.delete(id);
			        req.setAttribute("message", "Xóa thành công");
			    } catch (Exception e) {
			        e.printStackTrace();
			        req.setAttribute("error", "Xóa thất bại");
			    }
			    RequestDispatcher rd = req.getRequestDispatcher("home");
			    rd.forward(req, resp);
			}else if (url.contains("update")) {
				int id = Integer.parseInt(req.getParameter("id"));
			    BookModel_21110549 model = bookService.findOne(id);
			    req.setAttribute("listbook", model);
			    RequestDispatcher rd = req.getRequestDispatcher("/views/admin/updatebook.jsp");
			    rd.forward(req, resp);
			}else if (url.contains("listbookauthor")) {
				int id = Integer.parseInt(req.getParameter("authorId"));
				List<BookModel_21110549> listbookauthor = bookService.getBookByAuthor(id);
				req.setAttribute("listbook", listbookauthor);
				req.setAttribute("setactive", id);
				req.getRequestDispatcher("/views/admin/listbook.jsp").forward(req, resp);
			}else if(url.contains("detail")){
				 int id = Integer.parseInt(req.getParameter("id"));
		         BookModel_21110549 product = bookService.findOne(id);
		         req.setAttribute("book", product);
		            req.getRequestDispatcher("/views/admin/detail.jsp").forward(req, resp);
		            
			} 
			
			List<AuthorModel_21110549> listbook  = authorService.findAll();
			req.setAttribute("listcate", listbook);
			
			List<BookModel_21110549> countCID = bookService.count();
			req.setAttribute("countCID", countCID);
			
			
	}
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String url = req.getRequestURI().toString();
			if (url.contains("add")) {
				insert(req, resp);
			}
			else if (url.contains("update")) {
				update(req, resp);
			}
			else if (url.contains("delete")) {
				delete(req, resp);
			}
		
	}
	 
	 private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    req.setCharacterEncoding("UTF-8");
		    resp.setCharacterEncoding("UTF-8");
		    
		    try {
		        // Nhận dữ liệu từ form
		        int bookid = Integer.parseInt(req.getParameter("bookid"));
		        int ID = Integer.parseInt(req.getParameter("isbn"));
		        String title = req.getParameter("title");
		        String publisher = req.getParameter("publisher");
		        Double price = Double.parseDouble(req.getParameter("price"));
		        String description = req.getParameter("description");
		        String publish_date = req.getParameter("publish_date");

		        java.sql.Date sqlDate = null;  // Initialize the java.sql.Date variable

		        // Check if publish_date is not empty or null
		        if (publish_date != null && !publish_date.isEmpty()) {
		            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		            Date pd = dateFormat.parse(publish_date);
		            sqlDate = new java.sql.Date(pd.getTime()); // Convert java.util.Date to java.sql.Date
		        } else {
		            // If publish_date is empty or null, handle the error
		            String errorMessage = "Publish date is required. Please provide a valid date.";
		            req.setAttribute("error", errorMessage);

		            // Dispatch back to the addbook.jsp with an error message
		            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/updatebook.jsp");
		            rd.forward(req, resp);
		            return; // Stop further execution of the method
		        }

		        String cover_image = req.getParameter("cover_image");
		        int quantity = Integer.parseInt(req.getParameter("quantity"));

		        // Initialize the model
		        BookModel_21110549 model = new BookModel_21110549(bookid, ID, title, publisher, price, description, sqlDate, cover_image, quantity);

		        // Call the update method, passing the model with java.sql.Date
		        bookService.update(model);

		        // Redirect to the view
		        resp.sendRedirect("home");
		    } catch (Exception e) {
		        e.printStackTrace(); // Xử lý ngoại lệ
		        // Có thể bạn muốn thêm xử lý ngoại lệ cụ thể tại đây tùy theo nhu cầu ứng dụng của bạn.
		    }
		}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			int id = Integer.parseInt(req.getParameter("id"));
			bookService.delete(id);
			resp.sendRedirect("home");		
		}
	 private void insert(HttpServletRequest req, HttpServletResponse resp) {
		    try {
		        // Set character encoding
		        req.setCharacterEncoding("UTF-8");
		        resp.setCharacterEncoding("UTF-8");

		        // Receive data from the form

		        int ID = Integer.parseInt(req.getParameter("isbn"));
		        String title = req.getParameter("title");
		        String publisher = req.getParameter("publisher");
		        Double price = Double.parseDouble(req.getParameter("price"));
		        String description = req.getParameter("description");
		        String publish_date = req.getParameter("publish_date");

		        java.sql.Date sqlDate = null;  // Initialize the java.sql.Date variable

		        // Check if publish_date is not empty or null
		        if (publish_date != null && !publish_date.isEmpty()) {
		            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		            Date pd = dateFormat.parse(publish_date);
		            sqlDate = new java.sql.Date(pd.getTime()); // Convert java.util.Date to java.sql.Date
		        } else {
		            // If publish_date is empty or null, handle the error
		            String errorMessage = "Publish date is required. Please provide a valid date.";
		            req.setAttribute("error", errorMessage);

		            // Dispatch back to the addbook.jsp with an error message
		            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/addbook.jsp");
		            rd.forward(req, resp);
		            return; // Stop further execution of the method
		        }

		        String cover_image = req.getParameter("cover_image");
		        int quantity = Integer.parseInt(req.getParameter("quantity"));

		        // Initialize the model
		        BookModel_21110549 model = new BookModel_21110549(ID, title, publisher, price, description, sqlDate, cover_image, quantity);

		        // Call the insert method, passing the model with java.sql.Date
		        bookService.insert(model);

		        // Redirect to the view
		        resp.sendRedirect("home");
		    } catch (Exception e) {
		        e.printStackTrace(); // Handle the parsing or other exceptions as needed
		    }
		}
		

	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BookModel_21110549> list = bookService.findAll();

		// Đẩy dữ liệu ra view
		req.setAttribute("listbook", list);
		// view sẽ lấy dữ liệu
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/listbook.jsp");
		rd.forward(req, resp);
		
	}
}
