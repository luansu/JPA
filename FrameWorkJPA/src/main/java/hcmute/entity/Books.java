package hcmute.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="books")
@NamedQuery(name="Books.findAll()", query="SELECT b FROM Books b")
public class Books implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookid;
	private int isbn;
	private String title;
	private String publisher;
	private Double price;
	private String description;
	private Date publish_date;
	private String cover_image;
	private int quantity;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="book_author",
		joinColumns= {@JoinColumn(name="bookid")},
		inverseJoinColumns = {@JoinColumn(name="author_id")})
	private Set<Author> authors = new HashSet<Author>();
	
	@OneToMany(mappedBy="book")
	private List<Rating> rating_list;
	
	public Books() {
		super();
	}
	
	public Books(int bookid, int isbn, String title, String publisher, Double price, String description,
			Date publish_date, String cover_image, int quantity, Set<Author> authors, List<Rating> rating_list) {
		super();
		this.bookid = bookid;
		this.isbn = isbn;
		this.title = title;
		this.publisher = publisher;
		this.price = price;
		this.description = description;
		this.publish_date = publish_date;
		this.cover_image = cover_image;
		this.quantity = quantity;
		this.authors = authors;
		this.rating_list = rating_list;
	}

	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	public String getCover_image() {
		return cover_image;
	}
	public void setCover_image(String cover_image) {
		this.cover_image = cover_image;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public List<Rating> getRating_list() {
		return rating_list;
	}

	public void setRating_list(List<Rating> rating_list) {
		this.rating_list = rating_list;
	}
}
