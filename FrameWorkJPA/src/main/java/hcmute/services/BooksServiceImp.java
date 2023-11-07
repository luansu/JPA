package hcmute.services;

import java.util.List;

import hcmute.DAO.*;
import hcmute.entity.*;

public class BooksServiceImp implements IBooksService{
	IBooksDAO booksDAO = new BooksDAOImp();
	public List<Books> findAll() {
		return booksDAO.findAll();
	}
	
	public List<Books> getListBookByPage(List<Books> listbook, int start, int end){
		return booksDAO.getListBookByPage(listbook, start, end);
	}
	
	public Books findById(int bookid) {
		return booksDAO.findById(bookid);
	}

	public void insert(Books book) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int bookid) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void update(Books books) {
		// TODO Auto-generated method stub
		
	}
	
	public int countRating(int bookid) {
		return booksDAO.countRating(bookid);
	}
}
