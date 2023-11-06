package hcmute.Services;

import java.util.List;

import hcmute.models.BookModel_21110549;

public interface IBookService_21110549 {
	List<BookModel_21110549> findAllBookandAuthorID();
	List<BookModel_21110549> findAll();
	void insert(BookModel_21110549 model);
	void delete(int id);
	BookModel_21110549 findOne(int id);
	BookModel_21110549 findOneBookandAuthor(int id);
	
	void update(BookModel_21110549 model);
	List<BookModel_21110549> findAllPage(int index);
	List<BookModel_21110549> getBookByAuthor(int authorId);
	List<BookModel_21110549> count();
	

}
