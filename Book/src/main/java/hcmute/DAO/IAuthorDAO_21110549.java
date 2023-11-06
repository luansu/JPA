package hcmute.DAO;

import java.util.List;

import hcmute.models.AuthorModel_21110549;
import hcmute.models.BookModel_21110549;

public interface IAuthorDAO_21110549 {
	List<BookModel_21110549> getBookByAuthor(Integer authorId);
	
	List<BookModel_21110549> count();
	
	List<AuthorModel_21110549> findAll();
	
	AuthorModel_21110549 authorByBookID(int id);
	
	void insert(AuthorModel_21110549 author);
	void update(AuthorModel_21110549 author);
	void delete(AuthorModel_21110549 author);
	AuthorModel_21110549 findOne(int id);
}
