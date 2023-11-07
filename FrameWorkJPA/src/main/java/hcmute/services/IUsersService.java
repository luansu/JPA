package hcmute.services;

import java.util.List;

import hcmute.entity.Users;

public interface IUsersService {
	List<Users> findAll();
	Users findById(int id);
	void insert(Users user);
	void delete(int id) throws Exception;
	void update(Users user);
	
	Users login(String username, String password);
}
