package hcmute.services;

import java.util.List;

import hcmute.models.AuthorModels;

public interface IAuthorService {
	List<AuthorModels> findAll();
}
