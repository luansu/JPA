package hcmute.DAO;

import java.util.List;

import hcmute.entity.Rating;

public interface IRatingDAO {
	List<Rating> findAll();
	
	void insert(Rating rating);
	void delete(int bookid, int userid) throws Exception;
	void update(Rating rating);
}
