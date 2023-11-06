package hcmute.DAO;

import java.util.List;

import hcmute.models.BookAuthorModels;
import hcmute.models.BooksModels;

public interface IBookAuthorDAO {
	List<BookAuthorModels> findAll();

}
