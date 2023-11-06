package hcmute.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.models.BookAuthorModels;
import hcmute.models.BooksModels;

public class BookAuthorDAOImpl implements IBookAuthorDAO {

	Connection conn=null;
	PreparedStatement ps = null;
	ResultSet rs =null;
	
	@Override
	public List<BookAuthorModels> findAll() {

		List<BookAuthorModels> listbook_author = new ArrayList<BookAuthorModels>();
		String sql = "Select * from book_author";
		try {
		
			new DBConnectionSQLServer();
			conn = DBConnectionSQLServer.getConnectionW();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				BookAuthorModels book_author= new BookAuthorModels();
				book_author.setAuthor_id(rs.getInt("author_id"));
				book_author.setBookid(rs.getInt("bookid"));
				listbook_author.add(book_author);
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listbook_author;
	}

	
}
