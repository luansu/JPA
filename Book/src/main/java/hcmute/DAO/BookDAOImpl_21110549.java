package hcmute.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.models.AuthorModel_21110549;
import hcmute.models.BookModel_21110549;


public class BookDAOImpl_21110549 implements IBookDAO_21110549{

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public List<BookModel_21110549> findAll() {
		List<BookModel_21110549> books = new ArrayList<BookModel_21110549>();
        String sql = "SELECT * FROM books";
        try {

        	con = new SQLServerConnection_21110549().getConnection();
			// Ready for query
			ps = con.prepareStatement(sql);
			// Execute query and store result in ResultSet
			rs = ps.executeQuery();
            while (rs.next()) {
                BookModel_21110549 book = new BookModel_21110549();
                book.setBookid(rs.getInt("bookid"));
                book.setDescription(rs.getString("description"));
                book.setCover_image(rs.getString("cover_image"));
                book.setPrice(rs.getDouble("price"));
                book.setPublisher(rs.getString("publisher"));
                book.setIsbn(rs.getInt("isbn"));
                book.setQuantity(rs.getInt("quantity"));
                book.setPublish_date(rs.getDate("publish_date"));
                book.setTitle(rs.getString("title"));
                books.add(book);
            }} catch (Exception e) {
            e.printStackTrace();}
        return books;
	}
	@Override
	public void insert(BookModel_21110549 model) {
		String sql = "insert into books (isbn, title , publisher , price , description , publish_date, quantity ,cover_image ) VALUES (?,?,?,?,?,?,?,?)";
        try {
            System.out.println(model);
            con = new SQLServerConnection_21110549().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, model.getIsbn());
            ps.setString(2, model.getTitle());
            ps.setString(3, model.getPublisher());
            ps.setDouble(4, model.getPrice());
            ps.setString(5, model.getDescription());
            java.sql.Date sqlDate = new java.sql.Date(model.getPublish_date().getTime());
            ps.setDate(6, (Date) model.getPublish_date());
            ps.setInt(7, model.getQuantity());
            ps.setString(8, model.getCover_image());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	@Override
	public BookModel_21110549 findOne(int id) {
		String sql = "SELECT * FROM books WHERE bookid = ? ";

        try {

        	con = new SQLServerConnection_21110549().getConnection();
             ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BookModel_21110549 book = new BookModel_21110549();
                book.setBookid(rs.getInt("bookid"));
                book.setDescription(rs.getString("description"));
                book.setCover_image(rs.getString("cover_image"));
                book.setPrice(rs.getDouble("price"));
                book.setPublisher(rs.getString("publisher"));
                book.setIsbn(rs.getInt("isbn"));
                book.setQuantity(rs.getInt("quantity"));
                book.setPublish_date(rs.getDate("publish_date"));
                book.setTitle(rs.getString("title"));
                return book;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");

        }
        System.out.println("Error");
        return null;
	}
	@Override
	public void update(BookModel_21110549 model) {
	    System.out.println(model);
	    String sql = "UPDATE books SET isbn=?, title=?, publisher=?, price=?, description=?, publish_date=?, quantity=?, cover_image=? WHERE bookid = ?";
	    try {
	        con = new SQLServerConnection_21110549().getConnection();
	        ps = con.prepareStatement(sql);
	        ps.setInt(1, model.getIsbn());
	        ps.setString(2, model.getTitle());
	        ps.setString(3, model.getPublisher());
	        ps.setDouble(4, model.getPrice());
	        ps.setString(5, model.getDescription());
	        ps.setDate(6, model.getPublish_date()); // Sử dụng trực tiếp java.sql.Date
	        ps.setInt(7, model.getQuantity());
	        ps.setString(8, model.getCover_image());
	        ps.setInt(9, model.getBookid());
	        ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


	@Override
	public void delete(int id) {
		String sql = "DELETE FROM books WHERE bookid = ?";
        try {
        	con = new SQLServerConnection_21110549().getConnection();
             ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	@Override
	public List<BookModel_21110549> findAllPage(int index) {
		List<BookModel_21110549> books = new ArrayList<>();
		String sql = "SELECT * FROM books " +
	             "ORDER BY bookid " +
	             "OFFSET (" + ((index - 1) * 3) + ") ROWS " +
	             "FETCH NEXT " + 3+ " ROWS ONLY";
		try {
			con = new SQLServerConnection_21110549().getConnection();
            ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BookModel_21110549 book = new BookModel_21110549();
                book.setBookid(rs.getInt("bookid"));
                book.setDescription(rs.getString("description"));
                book.setCover_image(rs.getString("cover_image"));
                book.setPrice(rs.getDouble("price"));
                book.setPublisher(rs.getString("publisher"));
                book.setIsbn(rs.getInt("isbn"));
                book.setQuantity(rs.getInt("quantity"));
                book.setPublish_date(rs.getDate("publish_date"));
                book.setTitle(rs.getString("title"));
                books.add(book);
                
            }

		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;

	}
	@Override
	public int countAll() {
		String sql= "select count(*) from books";
		try {
        	con = new SQLServerConnection_21110549().getConnection();
			// Ready for query
			ps = con.prepareStatement(sql);
			// Execute query and store result in ResultSet
			rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	@Override
	public List<BookModel_21110549> getBookByAuthor(int authorId) {
		List<BookModel_21110549> productList = new ArrayList<BookModel_21110549>();
        String sql = "select b.bookid , b.cover_image , b.isbn , b.title, b.publish_date, b.price, b.[description], b.publisher , b.quantity, ba.author_id from books b \n" +
                "Inner join book_author ba ON b.bookid = ba.bookid and ba.author_id = ? ORDER BY b.bookid ;";
        try {
        	con = new SQLServerConnection_21110549().getConnection();
        	ps = con.prepareStatement(sql);

            ps.setInt(1, authorId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
              BookModel_21110549  book = new BookModel_21110549();
                book.setAuthorid(rs.getInt(10));
                book.setBookid(rs.getInt("bookid"));
                book.setDescription(rs.getString("description"));
                book.setCover_image(rs.getString("cover_image"));
                book.setPrice(rs.getDouble("price"));
                book.setPublisher(rs.getString("publisher"));
                book.setIsbn(rs.getInt("isbn"));
                book.setQuantity(rs.getInt("quantity"));
                book.setPublish_date(rs.getDate("publish_date"));
                book.setTitle(rs.getString("title"));
                productList.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return productList;
	}
	@Override
	public List<BookModel_21110549> count() {
		List<BookModel_21110549> list = new ArrayList<BookModel_21110549>();
		String sql = "SELECT aut.author_id, COUNT(*) as count FROM book_author as ba\r\n"
				+ "INNER JOIN books as b ON ba.bookid = b.bookid \r\n"
				+ "INNER JOIN author as aut ON ba.author_id = aut.author_id\r\n"
				+ "GROUP BY aut.author_id\r\n"
				+ "";
		
		try {
			// Connect database
			con = new SQLServerConnection_21110549().getConnection();
        	ps = con.prepareStatement(sql);
			// Execute query and store result in ResultSet
			rs = ps.executeQuery();
			
			while(rs.next()) {
				 BookModel_21110549  book = new BookModel_21110549();
	                book.setAuthorid(rs.getInt(1));
	                book.setTotal(rs.getInt(2));
	               list.add(book); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public List<BookModel_21110549> findAllBookandAuthorID() {
		List<BookModel_21110549> books = new ArrayList<BookModel_21110549>();
        String sql = "select *\r\n"
        		+ "from books b inner join book_author ba\r\n"
        		+ "on b.bookid = ba.bookid\r\n"
        		+ "inner join author a\r\n"
        		+ "on ba.author_id = a.author_id";
        try {

        	con = new SQLServerConnection_21110549().getConnection();
			// Ready for query
			ps = con.prepareStatement(sql);
			// Execute query and store result in ResultSet
			rs = ps.executeQuery();
            while (rs.next()) {
                BookModel_21110549 book = new BookModel_21110549();
                AuthorModel_21110549 author = new AuthorModel_21110549();
                book.setBookid(rs.getInt("bookid"));
                book.setDescription(rs.getString("description"));
                book.setCover_image(rs.getString("cover_image"));
                book.setPrice(rs.getDouble("price"));
                book.setPublisher(rs.getString("publisher"));
                book.setIsbn(rs.getInt("isbn"));
                book.setQuantity(rs.getInt("quantity"));
                book.setPublish_date(rs.getDate("publish_date"));
                book.setTitle(rs.getString("title"));
                
                author.setAuthorid(rs.getInt("author_id"));
                author.setAuthorname(rs.getString("author_name"));
                author.setDate_of_birth(rs.getDate("date_of_birth"));
                
                int count = new RatingDAOImpl_21110549().countRatingByBookID(book.getBookid());
                
                book.setAuthor(author);
                book.setTotal_reviews(count);
                books.add(book);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
	}
	@Override
	public BookModel_21110549 findOneBookandAuthor(int id) {
		String sql = "select *\r\n"
				+ "from books b inner join book_author ba\r\n"
				+ "on b.bookid = ba.bookid\r\n"
				+ "inner join author a\r\n"
				+ "on ba.author_id = a.author_id where b.bookid = ?";

        try {

        	con = new SQLServerConnection_21110549().getConnection();
             ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BookModel_21110549 book = new BookModel_21110549();
                AuthorModel_21110549 author = new AuthorModel_21110549();
                book.setBookid(rs.getInt("bookid"));
                book.setDescription(rs.getString("description"));
                book.setCover_image(rs.getString("cover_image"));
                book.setPrice(rs.getDouble("price"));
                book.setPublisher(rs.getString("publisher"));
                book.setIsbn(rs.getInt("isbn"));
                book.setQuantity(rs.getInt("quantity"));
                book.setPublish_date(rs.getDate("publish_date"));
                book.setTitle(rs.getString("title"));
                
                author.setAuthorid(rs.getInt("author_id"));
                author.setAuthorname(rs.getString("author_name"));
                author.setDate_of_birth(rs.getDate("date_of_birth"));
                
                int count = new RatingDAOImpl_21110549().countRatingByBookID(book.getBookid());
                
                book.setAuthor(author);
                book.setTotal_reviews(count);
                return book;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error");

        }
        System.out.println("Error");
        return null;
	}
	
	public static void main(String[] args) {
		BookDAOImpl_21110549 dao = new BookDAOImpl_21110549();
		BookModel_21110549 book = dao.findOneBookandAuthor(1);
		
		System.out.println(book);
	}

}
