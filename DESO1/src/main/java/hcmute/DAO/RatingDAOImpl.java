package hcmute.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.models.RatingModels;

public class RatingDAOImpl implements IRatingDAO {
	
	Connection conn=null;
	PreparedStatement ps = null;
	ResultSet rs =null;
	@Override
	public List<RatingModels> findAll() {

		List<RatingModels> listrating = new ArrayList<RatingModels>();
		String sql = "Select * from rating";
		try {
		
			new DBConnectionSQLServer();
			conn = DBConnectionSQLServer.getConnectionW();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				RatingModels rating = new RatingModels();
				rating.setUser_id(rs.getInt("userid"));
				rating.setBookid(rs.getInt("bookid"));
				rating.setRating(rs.getInt("rating"));
				rating.setReview_text(rs.getString("review_text"));
				listrating.add(rating);
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listrating;
	}
	@Override
	public List<RatingModels> listRatingbyID(int id) {
		List<RatingModels> listrating = new ArrayList<RatingModels>();
		String sql = "Select * from rating where userid = ?";
		try {
			conn = DBConnectionSQLServer.getConnectionW();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				RatingModels rating = new RatingModels();
				rating.setUser_id(rs.getInt("userid"));
				rating.setBookid(rs.getInt("bookid"));
				rating.setRating(rs.getInt("rating"));
				rating.setReview_text(rs.getString("review_text"));
				listrating.add(rating);
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listrating;
	}
}
