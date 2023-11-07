package hcmute.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Embeddable
public class RatingID implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column
	private int bookid;
	@Column
	private int userid;
	
	public RatingID() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RatingID(int bookid, int userid) {
		super();
		this.bookid = bookid;
		this.userid = userid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(bookid, userid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RatingID other = (RatingID) obj;
		return bookid == other.bookid && userid == other.userid;
	}
}
