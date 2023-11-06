package hcmute.Services;

import java.util.List;

import hcmute.DAO.IRatingDAO_21110549;
import hcmute.DAO.RatingDAOImpl_21110549;
import hcmute.models.RatingModels_21110549;

public class RatingServiceImpl_21110549 implements IRatingService_21110549{

	IRatingDAO_21110549 ratingDAO = new RatingDAOImpl_21110549();
	@Override
	public List<RatingModels_21110549> findAll() {
		return ratingDAO.findAll();
	}

	@Override
	public List<RatingModels_21110549> listRatingByBookID(int id) {
		return ratingDAO.listRatingByBookID(id);
	}

	@Override
	public int countRatingByBookID(int id) {
		return ratingDAO.countRatingByBookID(id);
	}

}
