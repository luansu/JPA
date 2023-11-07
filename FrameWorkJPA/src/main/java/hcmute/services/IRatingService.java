package hcmute.services;

import java.util.List;

import hcmute.entity.Rating;

public interface IRatingService {
	List<Rating> findAll();
	
	void insert(Rating rating);
	void delete(int bookid, int userid) throws Exception;
	void update(Rating rating);
}
