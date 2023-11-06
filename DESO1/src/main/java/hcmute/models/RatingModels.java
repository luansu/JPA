package hcmute.models;

import java.io.Serializable;

public class RatingModels implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int user_id;
	private int bookid;
	private int rating;
	private String review_text;
	public RatingModels(int user_id, int bookid, int rating, String review_text) {
		super();
		this.user_id = user_id;
		this.bookid = bookid;
		this.rating = rating;
		this.review_text = review_text;
	}
	public RatingModels() {
		super();
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview_text() {
		return review_text;
	}
	public void setReview_text(String review_text) {
		this.review_text = review_text;
	}
	
	
	
	
}
