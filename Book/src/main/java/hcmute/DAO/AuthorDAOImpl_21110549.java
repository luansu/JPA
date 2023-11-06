package hcmute.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.DAO.SQLServerConnection_21110549;
import hcmute.models.AuthorModel_21110549;
import hcmute.models.BookModel_21110549;

public class AuthorDAOImpl_21110549 implements IAuthorDAO_21110549{

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public List<BookModel_21110549> getBookByAuthor(Integer authorId) {
        List<BookModel_21110549> productList = new ArrayList<BookModel_21110549>();
        String sql = "select b.bookid , b.cover_image , b.isbn , b.title, b.publish_date, b.price, b.[description], b.publisher , b.quantity, ba.author_id from books b \n" +
                "Inner join book_author ba ON b.bookid = ba.bookid and ba.author_id = ? ORDER BY b.bookid ; \n";
        try {
        	con = new SQLServerConnection_21110549().getConnection();
			// Ready for query
			ps = con.prepareStatement(sql);
			// Execute query and store result in ResultSet
			rs = ps.executeQuery();

            ps.setInt(1, authorId);
            ResultSet rs = ps.executeQuery();
            BookModel_21110549 book;
            while (rs.next()) {
                book = new BookModel_21110549();
                book.setAuthorid(rs.getInt("10"));
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
		return null;
	}




	public static void main(String[] args) {
		IAuthorDAO_21110549 cateDao = new AuthorDAOImpl_21110549();
		List<AuthorModel_21110549> list = cateDao.findAll();

		for (AuthorModel_21110549 model : list) {
			System.out.println(model.toString());
		}
	}
	@Override
	public List<AuthorModel_21110549> findAll() {
			List<AuthorModel_21110549> list = new ArrayList<AuthorModel_21110549>();
			String sql = "SELECT * FROM author";
			
			try {
				// Connect database
				con = new SQLServerConnection_21110549().getConnection();
				// Ready for query
				ps = con.prepareStatement(sql);
				// Execute query and store result in ResultSet
				rs = ps.executeQuery();

				while (rs.next()) {
					AuthorModel_21110549 cate = new AuthorModel_21110549();
					cate.setAuthorid(rs.getInt(1));
					cate.setAuthorname(rs.getString(2));
					cate.setDate_of_birth(rs.getDate(3));					
					list.add(cate);
				}
				
				con.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	
	@Override
	public AuthorModel_21110549 authorByBookID(int id) {
		String query = "select a.author_id, author_name, date_of_birth from Author a inner join book_author ba\r\n"
				+ "on a.author_id = ba.author_id\r\n"
				+ "where bookid = ?";
		AuthorModel_21110549 author = new AuthorModel_21110549();
		
		try {
			
			// Connect database
			con = new SQLServerConnection_21110549().getConnection();
			// Ready for query
			ps = con.prepareStatement(query);
			// Execute query and store result in ResultSet
			rs = ps.executeQuery();

			while (rs.next()) {
				author.setAuthorid(rs.getInt(1));
				author.setAuthorname(rs.getNString(2));
				author.setDate_of_birth(rs.getDate(3));	
			}
			con.close();
			
		} catch (Exception e) {
			return null;
		}
		return author;
	}
	@Override
	public void insert(AuthorModel_21110549 author) {
		String query = "insert into author values (?, ?)";
		try {

			con = new SQLServerConnection_21110549().getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, author.getAuthorname()); 
			ps.setDate(2, author.getDate_of_birth());
			ps.executeUpdate();
			con.close();

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void update(AuthorModel_21110549 author) {
		String query = "update author set author_name = ?, date_of_birth = ? where author_id = ?";
		try {

			con = new SQLServerConnection_21110549().getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, author.getAuthorname()); 
			ps.setDate(2, author.getDate_of_birth());
			ps.setInt(3, author.getAuthorid());
			ps.executeUpdate();
			con.close();

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void delete(AuthorModel_21110549 author) {
		String query = "delete author where author_id = ?";
		try {

			con = new SQLServerConnection_21110549().getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, author.getAuthorid());
			ps.executeUpdate();
			con.close();

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public AuthorModel_21110549 findOne(int id) {
		String sql = "SELECT * FROM author where author_id = ?";
		AuthorModel_21110549 author = new AuthorModel_21110549();
		try {
			// Connect database
			con = new SQLServerConnection_21110549().getConnection();
			// Ready for query
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			// Execute query and store result in ResultSet
			rs = ps.executeQuery();

			while (rs.next()) {
				author.setAuthorid(rs.getInt(1));
				author.setAuthorname(rs.getString(2));
				author.setDate_of_birth(rs.getDate(3));	
			}
			
			con.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return author;
	}
}


