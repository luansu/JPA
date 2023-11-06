package hcmute.Services;


import java.util.List;

import hcmute.DAO.AuthorDAOImpl_21110549;
import hcmute.DAO.BookDAOImpl_21110549;
import hcmute.DAO.IAuthorDAO_21110549;
import hcmute.DAO.IBookDAO_21110549;
import hcmute.models.BookModel_21110549;

public class BookServiceImpl_21110549 implements IBookService_21110549 {

	IBookDAO_21110549 bookDao = new BookDAOImpl_21110549();
	IAuthorDAO_21110549 authorDao = new AuthorDAOImpl_21110549();
	@Override
	public List<BookModel_21110549> findAll() {
		// TODO Auto-generated method stub
		return bookDao.findAll();
	}
	@Override
	public void insert(BookModel_21110549 model) {
		// TODO Auto-generated method stub
		bookDao.insert(model);
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		bookDao.delete(id);
		
	}
	@Override
	public BookModel_21110549 findOne(int id) {
		
		return bookDao.findOne(id);
	}
	@Override
	public void update(BookModel_21110549 item) {

		System.out.println(item);
        BookModel_21110549 oldBook = bookDao.findOne(item.getBookid());
        oldBook.setTitle(item.getTitle());
        oldBook.setQuantity(item.getQuantity());
        oldBook.setIsbn(item.getIsbn());
        oldBook.setPublisher(item.getPublisher());
        oldBook.setPrice(item.getPrice());
        oldBook.setDescription(item.getDescription());
        oldBook.setPublish_date(item.getPublish_date());

        oldBook.setCover_image(item.getCover_image());
        
        bookDao.update(oldBook);
	}
	@Override
	public List<BookModel_21110549> findAllPage(int index) {
		// TODO Auto-generated method stub
		return bookDao.findAllPage(index);
		
	}
	@Override
	public List<BookModel_21110549> getBookByAuthor(int authorId) {
		
		return bookDao.getBookByAuthor(authorId);
	}
	@Override
	public List<BookModel_21110549> count() {
		
		return bookDao.count();
	}
	@Override
	public List<BookModel_21110549> findAllBookandAuthorID() {
		return bookDao.findAllBookandAuthorID();
	}
	@Override
	public BookModel_21110549 findOneBookandAuthor(int id) {
		return bookDao.findOneBookandAuthor(id);
	}

}
