package hcmute.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="author")
@NamedQuery(name="Author.findAll", query="SELECT au FROM Author au")
public class Author implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int authorid;
	private String author_name;
	private Date date_of_birth;
	
	@ManyToMany(mappedBy="authors")
	private Set<Books> books = new HashSet<Books>();

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(int authorid, String author_name, Date date_of_birth, Set<Books> books) {
		super();
		this.authorid = authorid;
		this.author_name = author_name;
		this.date_of_birth = date_of_birth;
		this.books = books;
	}

	public int getAuthorid() {
		return authorid;
	}

	public void setAuthorid(int authorid) {
		this.authorid = authorid;
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

	public Set<Books> getBooks() {
		return books;
	}

	public void setBooks(Set<Books> books) {
		this.books = books;
	}
}
