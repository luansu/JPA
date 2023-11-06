package hcmute.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.models.BooksModels;
import hcmute.models.RatingModels;


public class BooksDAOImpl implements IBooksDAO{

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public List<BooksModels> findAll() {
		List<BooksModels> listModel = new ArrayList<BooksModels>();
		
		try {
			
			conn = DBConnectionSQLServer.getConnectionW();
			
			String query = "select * from books";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BooksModels user = new BooksModels();
				user.setBookid(rs.getInt(1));
				user.setIsbn(rs.getInt(2));
				user.setTitle(rs.getString(3));
				user.setPublisher(rs.getString(4));
				user.setPrice(rs.getFloat(5));
				user.setDescription(rs.getString(6));
				user.setPublish_date(rs.getDate(7));
				user.setCover_image(rs.getString(8));
				user.setQuantity(rs.getInt(9));
				listModel.add(user);
			}
			
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return listModel;			
	}
	
	@Override
	public void insert(BooksModels model) {
		// xử lý themm category
		String sql = "INSERT INTO books (isbn, title, publisher, price, description, publish_date, cover_image, quantity) values(?,?,?,?,?,?,?,?)";

		try {
			new DBConnectionSQLServer();
			// Kết nối dữ liệu
			conn = DBConnectionSQLServer.getConnectionW();
			ps = conn.prepareStatement(sql);
			// gán giá trị cho tham số
			ps.setInt(1, model.getIsbn());
			ps.setString(2, model.getTitle());
			ps.setString(3, model.getPublisher());
			ps.setFloat(4, model.getPrice());
			ps.setString(5, model.getDescription());
			ps.setDate(6, model.getPublish_date());
			ps.setString(7, model.getCover_image());
			ps.setInt(8, model.getQuantity());
			ps.executeUpdate();// thực thi câu querry
			
			conn.close();

		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public BooksModels findOne(int id) {
		// Xử lý dữ liệu lấy ra 1 đối tượng Cate
				String query = "select * from books where bookid = ?"; // ? : tham số
				BooksModels book = new BooksModels();
				try {

					conn = DBConnectionSQLServer.getConnectionW();
					ps = conn.prepareStatement(query);
					ps.setInt(1, id); // Đổi tham số
					rs = ps.executeQuery(); // select thì execute Query
					while (rs.next()) {
						book.setBookid(rs.getInt(1));
						book.setIsbn(rs.getInt(2));
						book.setTitle(rs.getString(3));
						book.setPublisher(rs.getString(4));
						book.setPrice(rs.getFloat(5));
						book.setDescription(rs.getString(6));
						book.setPublish_date(rs.getDate(7));
						book.setCover_image(rs.getString(8));
						book.setQuantity(rs.getInt(9));
					}
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return book;
		}  


	 @Override 
	 public void delete(int id) { 
		 String sql = "delete from books where bookid = ?"; 
		 try { 
			 new DBConnectionSQLServer();
			 conn = DBConnectionSQLServer.getConnectionW(); 
			 ps = conn.prepareStatement(sql); 
			 ps.setInt(1, id); 
			 ps.executeUpdate(); 
			 conn.close();
	 
		 } catch (Exception e) { 
			 e.printStackTrace(); 
		 } 
	 }
	 
	 @Override
		public void update(BooksModels book) {
			String query = "update books set isbn=?, title=?, publisher=?, price=?, description=?, publish_date=?, cover_image=?, quantity=? where bookid=?";
			try {
				conn = DBConnectionSQLServer.getConnectionW();
				ps = conn.prepareStatement(query);
				ps.setInt(1, book.getIsbn());
				ps.setString(2, book.getTitle());
				ps.setString(3, book.getPublisher());
				ps.setFloat(4, book.getPrice());
				ps.setString(5, book.getDescription());
				ps.setDate(6, book.getPublish_date());
				ps.setString(7, book.getCover_image());
				ps.setInt(8, book.getQuantity());
				ps.setInt(9, book.getBookid());
				ps.executeUpdate();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 @Override
		public List<BooksModels> getListBookByPage(List<BooksModels> list, int x, int y) {
			List<BooksModels> listBook = new ArrayList<>();
			
			for (int i = x; i < y; i++) {
				listBook.add(list.get(i));
			}
			
			return listBook;
		}

	 @Override
		public List<BooksModels> getListBookByAuthorID(int idAuthor) {
			List<BooksModels> listBook = new ArrayList<BooksModels>();
			
			String query = "select books.bookid, isbn, title, publisher, price, description, publish_date, cover_image, quantity from book_author inner join books on book_author.bookid = books.bookid where author_id = ?";
			
			try {
				
				conn = DBConnectionSQLServer.getConnectionW();
				
				ps = conn.prepareStatement(query);
				ps.setInt(1, idAuthor);
				rs = ps.executeQuery();
				
				while (rs.next()) {
					BooksModels book = new BooksModels();
					book.setBookid(rs.getInt(1));
					book.setIsbn(rs.getInt(2));
					book.setTitle(rs.getString(3));
					book.setPublisher(rs.getString(4));
					book.setPrice(rs.getFloat(5));
					book.setDescription(rs.getString(6));
					book.setPublish_date(rs.getDate(7));
					book.setCover_image(rs.getString(8));
					book.setQuantity(rs.getInt(9));
					listBook.add(book);
				}
				
				conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return listBook;
	 }

	 @Override
		public List<BooksModels> getListBookByRatingScore() {
			
			List<BooksModels> listBook = new ArrayList<BooksModels>();
			String query = "select * from books inner join rating on books.bookid = rating.bookid\r\n"
					+ "order by rating desc";
			try {
				
				conn = DBConnectionSQLServer.getConnectionW();
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				while(rs.next()) {
					BooksModels book = new BooksModels();
					RatingModels rating = new RatingModels();
					book.setBookid(rs.getInt(1));
					book.setIsbn(rs.getInt(2));
					book.setTitle(rs.getString(3));
					book.setPublisher(rs.getString(4));
					book.setPrice(rs.getFloat(5));
					book.setDescription(rs.getString(6));
					book.setPublish_date(rs.getDate(7));
					book.setCover_image(rs.getString(8));
					book.setQuantity(rs.getInt(9));
					rating.setUser_id(rs.getInt(10));
					rating.setBookid(rs.getInt(11));
					rating.setRating(rs.getInt(12));
					rating.setReview_text(rs.getString(13));
					book.setRating(rating);
					listBook.add(book);
				}
				
				conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return listBook;
		}
}
	 
