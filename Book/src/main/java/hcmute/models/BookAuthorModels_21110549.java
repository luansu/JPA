package hcmute.models;

import java.io.Serializable;

public class BookAuthorModels_21110549 implements Serializable{

	private static final long serialVersionUID = 1L;

	private int author_id;
	private int bookid;
	
	public BookAuthorModels_21110549() {
		super();
	}
	
	public BookAuthorModels_21110549(int author_id, int bookid) {
		super();
		this.author_id = author_id;
		this.bookid = bookid;
	}
	
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
}
