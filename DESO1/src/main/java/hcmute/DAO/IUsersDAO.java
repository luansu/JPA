package hcmute.DAO;

import java.util.List;

import hcmute.models.UsersModels;

public interface IUsersDAO {
	List<UsersModels> findAll();
	UsersModels findOne(String username);
	UsersModels findInfor(int id);
}