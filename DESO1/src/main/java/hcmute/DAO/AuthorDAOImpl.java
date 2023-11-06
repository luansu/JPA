package hcmute.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.models.AuthorModels;

public class AuthorDAOImpl implements IAuthorDAO  {

	Connection conn=null;
	PreparedStatement ps = null;
	ResultSet rs =null;
	@Override
	public List<AuthorModels> findAll() {

		List<AuthorModels> listauthor = new ArrayList<AuthorModels>();
		String sql = "Select * from author";
		try {
		
			new DBConnectionSQLServer();
			conn = DBConnectionSQLServer.getConnectionW();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				AuthorModels author= new AuthorModels();
				author.setAuthor_id(rs.getInt("author_id"));
				author.setAuthor_name(rs.getString("author_name"));
				author.setDate_of_birth(rs.getDate("date_of_birth"));
				listauthor.add(author);
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listauthor;
	}
}
