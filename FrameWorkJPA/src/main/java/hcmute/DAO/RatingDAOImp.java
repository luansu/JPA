package hcmute.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import hcmute.JPAConfig.JPAConfig;
import hcmute.entity.Rating;

public class RatingDAOImp implements IRatingDAO{
	EntityManager enma = JPAConfig.getEntityManager();
	EntityTransaction trans = enma.getTransaction();
	public List<Rating> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public 	List<Rating> findByBookId(int bookid){
		String jpql = "SELECT r FROM Rating r WHERE r.ratingid.bookid like :bookid";
		TypedQuery<Rating> query = enma.createQuery(jpql, Rating.class);
		query.setParameter("bookid", bookid);
		return query.getResultList();
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
