package hcmute.services;

import java.util.List;

import hcmute.DAO.AuthorDAOImpl;

import hcmute.DAO.IAuthorDAO;

import hcmute.models.AuthorModels;


public class AuthorServiceImpl implements IAuthorService {

	IAuthorDAO authorDAO = new AuthorDAOImpl();
	
	@Override
	public List<AuthorModels> findAll() {
		// xử lý logic nếu có
		// gọi và truyền cho DAO
		return authorDAO.findAll();
	}

}
