package hcmute.DAO;

import java.util.List;

import hcmute.models.RatingModels_21110549;

public interface IRatingDAO_21110549 {
	List<RatingModels_21110549> findAll();
	
	List<RatingModels_21110549> listRatingByBookID(int id);
	
	int countRatingByBookID(int id);
}
