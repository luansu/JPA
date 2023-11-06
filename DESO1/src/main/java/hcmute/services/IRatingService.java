package hcmute.services;

import java.util.List;

import hcmute.models.RatingModels;
import hcmute.models.UsersModels;

public interface IRatingService {
	List<RatingModels> findAll();
	List<RatingModels> listRatingbyID(int id);
}
