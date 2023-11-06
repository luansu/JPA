package hcmute.services;

import java.util.List;

import hcmute.models.BookAuthorModels;

public interface IBookAuthorService {
	List<BookAuthorModels> findAll();
}
