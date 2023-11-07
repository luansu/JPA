package hcmute.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import hcmute.JPAConfig.JPAConfig;
import hcmute.entity.Users;

public class UsersDAOImp implements IUsersDAO{
	EntityManager enma = JPAConfig.getEntityManager();
	EntityTransaction trans = enma.getTransaction();
	public List<Users> findAll() {
		TypedQuery<Users> users = enma.createNamedQuery("Users.findAll", Users.class);
		return users.getResultList();
	}

	public Users findById(int id) {
		String jpql = "SELECT u FROM Users WHERE u.id like :id";
		TypedQuery<Users> user = enma.createQuery(jpql, Users.class);
		user.setParameter("id", id);
		return user.getSingleResult();
	}

	public void insert(Users user) {
		try {
			trans.begin();
			enma.persist(user);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}

	public void delete(int id) throws Exception {
		try {
			
			trans.begin();
			Users user = findById(id);
			if (user != null) {
				enma.remove(user);
			} else {
				throw new Exception("Khong tim thay");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}

	public void update(Users user) {
		try {
			trans.begin();
			enma.merge(user);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
	}
	
	public Users login(String username) {
		String jpql = "SELECT u FROM Users u WHERE u.email like :username";
		TypedQuery<Users> query = enma.createQuery(jpql, Users.class);
		query.setParameter("username",username);
		Users user = query.getSingleResult();
		if(user != null) {
			return user;
		}
		return null;
	}
}
