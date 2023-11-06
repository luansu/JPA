package hcmute.models;

import java.io.Serializable;
import java.sql.Date;

public class AuthorModel_21110549 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int authorid;
	private String authorname;
	private java.sql.Date date_of_birth;
	private int total;
	public AuthorModel_21110549(int authorid, int total) {
		super();
		this.authorid = authorid;
		this.total = total;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public java.sql.Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(java.sql.Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public AuthorModel_21110549(int authorid, String authorname, Date date_of_birth) {
		super();
		this.authorid = authorid;
		this.authorname = authorname;
		this.date_of_birth = date_of_birth;
	}
	public AuthorModel_21110549() {
		 super();
	}
	@Override
	public String toString() {
		return "AuthorModel [authorid=" + authorid + ", authorname=" + authorname + ", date_of_birth=" + date_of_birth
				+ "]";
	}

}
