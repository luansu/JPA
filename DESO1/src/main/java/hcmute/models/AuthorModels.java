package hcmute.models;

import java.io.Serializable;
import java.util.Date;

public class AuthorModels implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int author_id;
	private String author_name;
	private Date date_of_birth;
	
	public AuthorModels(int author_id, String author_name, Date date_of_birth) {
		super();
		this.author_id = author_id;
		this.author_name = author_name;
		this.date_of_birth = date_of_birth;
	}
	
	public AuthorModels() {
		super();
	}
	
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	
	
	
}
