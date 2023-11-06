package hcmute.services;

import java.util.List;

import hcmute.DAO.IRatingDAO;
import hcmute.DAO.RatingDAOImpl;
import hcmute.models.RatingModels;

public class RatingServiceImpl implements IRatingService{
	
	IRatingDAO ratingDAO = new RatingDAOImpl();

	@Override
	public List<RatingModels> findAll() {

		return ratingDAO.findAll();
	}

	@Override
	public List<RatingModels> listRatingbyID(int id) {
		return ratingDAO.listRatingbyID(id);
	}
	
}
