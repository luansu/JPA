package hcmute.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="rating")
@NamedQuery(name="Rating.findAll", query="SELECT r FROM Rating r")
public class Rating implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private RatingID ratingid;
	@Column
	private int rating;
	@Column
	private String review_text;
	
	@ManyToOne
	@JoinColumn(name="bookid", insertable = false, updatable = false)
	private Books book;
	
	@ManyToOne
	@JoinColumn(name="userid", insertable = false, updatable = false)
	private Users user;

	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rating(RatingID ratingid, int rating, String review_text, Books book, Users user) {
		super();
		this.ratingid = ratingid;
		this.rating = rating;
		this.review_text = review_text;
		this.book = book;
		this.user = user;
	}

	public RatingID getRatingid() {
		return ratingid;
	}

	public void setRatingid(RatingID ratingid) {
		this.ratingid = ratingid;
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

	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
}
