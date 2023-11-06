package hcmute.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.models.RatingModels_21110549;

public class RatingDAOImpl_21110549 implements IRatingDAO_21110549 {
	
	Connection conn=null;
	PreparedStatement ps = null;
	ResultSet rs =null;
	@Override
	public List<RatingModels_21110549> findAll() {

		List<RatingModels_21110549> listrating = new ArrayList<RatingModels_21110549>();
		String sql = "Select * from rating";
		try {
		
			conn = new SQLServerConnection_21110549().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				RatingModels_21110549 rating = new RatingModels_21110549();
				rating.setUserid(rs.getInt("userid"));
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
	public List<RatingModels_21110549> listRatingByBookID(int id) {
		List<RatingModels_21110549> listrating = new ArrayList<RatingModels_21110549>();
		String sql = "Select * from rating where bookid = ?";
		try {
			conn = new SQLServerConnection_21110549().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				RatingModels_21110549 rating = new RatingModels_21110549();
				rating.setUserid(rs.getInt("userid"));
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
	public int countRatingByBookID(int id) {
		int count = 0;
		String sql = "Select count(*) from rating where bookid = ?";
		try {
			conn = new SQLServerConnection_21110549().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}