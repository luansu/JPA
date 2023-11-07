package hcmute.services;

import java.util.List;

import hcmute.DAO.*;
import hcmute.entity.*;

public class RatingServiceImp implements IRatingService{
	
	IRatingDAO ratingDAO = new RatingDAOImp();
	public List<Rating> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public 	List<Rating> findByBookId(int bookid){
		return ratingDAO.findByBookId(bookid);
	}

	public void insert(Rating rating) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int bookid, int userid) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void update(Rating rating) {
		// TODO Auto-generated method stub
		
	}
	
}
