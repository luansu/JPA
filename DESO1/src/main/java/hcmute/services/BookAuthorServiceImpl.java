package hcmute.services;

import java.util.List;

import hcmute.DAO.AuthorDAOImpl;
import hcmute.DAO.BookAuthorDAOImpl;
import hcmute.DAO.IBookAuthorDAO;
import hcmute.models.AuthorModels;
import hcmute.models.BookAuthorModels;

public class BookAuthorServiceImpl implements IBookAuthorService {
	IBookAuthorDAO book_authorDAO = new BookAuthorDAOImpl();
	
	@Override
	public List<BookAuthorModels> findAll() {
		// xử lý logic nếu có
		// gọi và truyền cho DAO
		return book_authorDAO.findAll();
	}
}
