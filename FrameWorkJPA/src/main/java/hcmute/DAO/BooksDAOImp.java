package hcmute.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import hcmute.JPAConfig.JPAConfig;
import hcmute.entity.Books;

public class BooksDAOImp implements IBooksDAO{
	
	EntityManager enma = JPAConfig.getEntityManager();
	EntityTransaction trans = enma.getTransaction();
	public List<Books> findAll() {
		TypedQuery<Books> query = enma.createNamedQuery("Books.findAll()", Books.class);
		return query.getResultList();
	}
	
	public Books findById(int bookid) {
		String jpql = "SELECT b FROM Books b WHERE b.bookid like :bookid";
		TypedQuery<Books> query = enma.createQuery(jpql, Books.class);
		query.setParameter("bookid", bookid);
		return query.getSingleResult();
	}
	
	public List<Books> getListBookByPage(List<Books> listbook, int start, int end){
		List<Books> listbooByPage = new ArrayList<>();
		
		for (int i = start; i < end; i++) {
			listbooByPage.add(listbook.get(i));
		}
		return listbooByPage;
	}


	public void insert(Books book) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int bookid) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void update(Books book) {
		// TODO Auto-generated method stub
		
	}
	
	public int countRating(int bookid) {
		String jpql = "SELECT b FROM Books b WHERE b.bookid like :bookid";
		TypedQuery<Books> query = enma.createQuery(jpql, Books.class);
		query.setParameter("bookid", bookid);
		Books listBooks = query.getSingleResult();
		return listBooks.getRating_list().size();
//		javax.management.Query query = (javax.management.Query) enma.createQuery(jpql, Rating.class);
//		return ((Long)((javax.persistence.Query) query).getSingleResult()).intValue();
	}
	
	public static void main(String[] args) {
		try {
			IBooksDAO book = new BooksDAOImp();
			System.out.println("So rating:" + book.countRating(4));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
