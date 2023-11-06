package hcmute.services;

import java.util.List;

import hcmute.models.UsersModels;

public interface IUsersService {
	List<UsersModels> findAll();

	UsersModels login(String username, String passwd);
	UsersModels findOne(String username);
	UsersModels findInfor(int id);
}
