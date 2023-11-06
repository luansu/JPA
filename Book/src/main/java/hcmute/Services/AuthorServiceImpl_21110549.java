package hcmute.Services;


import java.util.List;

import hcmute.DAO.AuthorDAOImpl_21110549;
import hcmute.DAO.BookDAOImpl_21110549;
import hcmute.DAO.IAuthorDAO_21110549;
import hcmute.DAO.IBookDAO_21110549;
import hcmute.models.AuthorModel_21110549;
import hcmute.models.BookModel_21110549;

public class AuthorServiceImpl_21110549 implements IAuthorService_21110549 {

	IAuthorDAO_21110549 authorDao = new AuthorDAOImpl_21110549();
	@Override
	public List<BookModel_21110549> getBookByAuthor(Integer authorId) {
		  return authorDao.getBookByAuthor(authorId);
	}

	@Override
	public List<BookModel_21110549> count() {
		return authorDao.count();
	}

	@Override
	public List<AuthorModel_21110549> findAll() {
	return authorDao.findAll();	}

	@Override
	public AuthorModel_21110549 authorByBookID(int id) {
		return authorDao.authorByBookID(id);
	}

	@Override
	public void insert(AuthorModel_21110549 author) {
		authorDao.insert(author);
		
	}

	@Override
	public void update(AuthorModel_21110549 author) {
		AuthorModel_21110549 newAuthor = authorDao.findOne(author.getAuthorid());
		
		newAuthor.setAuthorname(author.getAuthorname());
		newAuthor.setDate_of_birth(author.getDate_of_birth());
		
		authorDao.update(newAuthor);
		
	}

	@Override
	public void delete(AuthorModel_21110549 author) {
		authorDao.delete(author);
		
	}

	@Override
	public AuthorModel_21110549 findOne(int id) {
		return authorDao.findOne(id);
	}

	

}
