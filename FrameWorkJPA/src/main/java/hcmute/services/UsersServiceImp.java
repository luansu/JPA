package hcmute.services;

import java.util.List;

import hcmute.DAO.IUsersDAO;
import hcmute.DAO.UsersDAOImp;
import hcmute.entity.Users;

public class UsersServiceImp implements IUsersService{
	IUsersDAO userDAO = new UsersDAOImp();
	public List<Users> findAll() {
		return userDAO.findAll();
	}
	
	public Users findById(int id) {
		return userDAO.findById(id);
	}

	public void insert(Users user) {
		userDAO.insert(user);
	}

	public void delete(int id) throws Exception {
		userDAO.delete(id);
	}

	public void update(Users user) {
		userDAO.update(user);
	}
	
	public Users login(String username, String password) {
		Users user = userDAO.login(username);
		if(user != null && user.getPasswd().equals(password)) {
			return user;
		}
		return null;
	}
}
