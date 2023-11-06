package hcmute.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.models.UsersModels;

public class UsersDAOImpl implements IUsersDAO{

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public List<UsersModels> findAll() {
		List<UsersModels> listModel = new ArrayList<UsersModels>();
		
		try {
			
			conn = DBConnectionSQLServer.getConnectionW();
			
			String query = "select * from users";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				UsersModels user = new UsersModels();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setFullname(rs.getString("fullname"));
				user.setPhone(rs.getInt("phone"));
				user.setPasswd(rs.getString("passwd"));
				user.setSignup_date(rs.getDate("signup_date"));
				user.setLast_login(rs.getDate("last_login"));
				user.setIs_admin(rs.getBoolean("is_admin"));
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
	public UsersModels findOne(String username) {
		UsersModels user = new UsersModels();
		String query = "select * from Users where username = ?";
		try {
			conn = DBConnectionSQLServer.getConnectionW();
			ps = conn.prepareStatement(query);
			ps.setString(1,  username);
			rs = ps.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setFullname(rs.getString(4));
				user.setPhone(rs.getInt(5));
				user.setPasswd(rs.getString(6));
				user.setSignup_date(rs.getDate(7));
				user.setLast_login(rs.getDate(8));
				user.setIs_admin(rs.getBoolean(9));
			}
			else {
				return null;
			}
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return user;
	}
	@Override
	public UsersModels findInfor(int id) {
		UsersModels user = new UsersModels();
		String query = "select id, fullname, email from Users where id=?";
		try {
			conn = DBConnectionSQLServer.getConnectionW();
			ps = conn.prepareStatement(query);
			ps.setInt(1,  id);
			rs = ps.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setFullname(rs.getString("fullname"));
				user.setEmail(rs.getString("email"));	
			}
			else {
				return null;
			}
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return user;
	}
	
	

}