package hcmute.services;

import java.util.List;

import hcmute.entity.Author;

public interface IAuthorService {
	List<Author> findAll();
	
	void insert(Author author);
	void delete(int authorid) throws Exception;
	void update(Author author);
}
