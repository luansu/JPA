package hcmute.services;

import java.util.List;

import hcmute.DAO.BooksDAOImpl;
import hcmute.DAO.IBooksDAO;
import hcmute.models.BooksModels;

public class BooksServiceImpl implements IBooksService{
	IBooksDAO booksDAO = new BooksDAOImpl();

	@Override
	public List<BooksModels> findAll() {
		
		return booksDAO.findAll();
	}

	@Override
	public void insert(BooksModels model) {
		booksDAO.insert(model);
		
	}

	@Override
	public BooksModels findOne(int id) {
		return booksDAO.findOne(id);
	}

	@Override
	public void delete(int id) {
		booksDAO.delete(id);
		
	}

	@Override
	public void update(BooksModels book) {
		booksDAO.update(book);
		
	}
	@Override
	public List<BooksModels> getListBookByPage(List<BooksModels> list, int x, int y) {
		return booksDAO.getListBookByPage(list, x, y);
	}

	@Override
	public List<BooksModels> getListBookByAuthorID(int id) {
		return booksDAO.getListBookByAuthorID(id);
	}

	@Override
	public List<BooksModels> getListBookByRatingScore() {
		return booksDAO.getListBookByRatingScore();
	}
}
