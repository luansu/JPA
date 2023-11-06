package hcmute.services;

import java.util.List;

import hcmute.DAO.IUsersDAO;
import hcmute.DAO.UsersDAOImpl;
import hcmute.models.UsersModels;

public class UsersServiceImpl implements IUsersService {
	IUsersDAO usersDAO = new UsersDAOImpl();

	@Override
	public List<UsersModels> findAll() {
		return usersDAO.findAll();
	}

	@Override
	public UsersModels findOne(String username) {
		return usersDAO.findOne(username);
	}
	@Override
	public UsersModels login(String username, String passwd) {
		UsersModels user = this.findOne(username);
		if (user != null && passwd.equals(user.getPasswd())) {
			return user;
		}
		return null;
	}
	
	@Override
	public UsersModels findInfor(int id) {
		return usersDAO.findInfor(id);
	}

}
