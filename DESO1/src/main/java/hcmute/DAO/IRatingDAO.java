package hcmute.DAO;

import java.util.List;

import hcmute.models.RatingModels;

public interface IRatingDAO {
	List<RatingModels> findAll();
	List<RatingModels> listRatingbyID(int id);
}
