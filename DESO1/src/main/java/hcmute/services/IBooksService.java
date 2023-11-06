package hcmute.services;

import java.util.List;

import hcmute.models.BooksModels;


public interface IBooksService {
	List<BooksModels> findAll();

	void insert (BooksModels model);

	BooksModels findOne(int id);
	void delete(int id);

	void update(BooksModels book);

	List<BooksModels> getListBookByPage(List<BooksModels> list, int x, int y);

	List<BooksModels> getListBookByAuthorID(int id);

	List<BooksModels> getListBookByRatingScore();


}
