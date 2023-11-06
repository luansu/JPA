package luansu.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Category")
@NamedQuery(name ="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryID;
	private String categoryName;
	private String images;
	
	@OneToMany(mappedBy="category", fetch=FetchType.EAGER)
	private List<Product> products;
	 
	// tạo các constructor
	
	public Category() {
		super();
	}

	public Category(int categoryID, String categoryName, String images, List<Product> products) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.images = images;
		this.products = products;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
