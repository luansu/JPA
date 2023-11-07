package hcmute.services;

import java.util.List;

import hcmute.entity.Books;

public interface IBooksService{
	List<Books> findAll();
	List<Books> getListBookByPage(List<Books> listbook, int start, int end);
	Books findById(int bookid);
	
	void insert(Books book);
	void delete(int bookid) throws Exception;
	void update(Books book);
	
	int countRating(int bookid);
}
