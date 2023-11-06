package hcmute.DAO;

import java.util.List;

import hcmute.models.AuthorModels;


public interface IAuthorDAO {
	List<AuthorModels> findAll();
}
