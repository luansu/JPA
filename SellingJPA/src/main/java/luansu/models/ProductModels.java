package luansu.models;

import java.io.Serializable;

public class ProductModels implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int productID;
	private String productName;
	private String description;
	private int price;
	private String imageLink;
	private int categoryID;
	private int sellerID;
	private int amount;
	private int stoke;
	
	CategoryModels category;

	public ProductModels() {
		super();
	}

	public ProductModels(int productID, String productName, String description, int price, String imageLink,
			int categoryID, int sellerID, int amount, int stoke, CategoryModels category) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.imageLink = imageLink;
		this.categoryID = categoryID;
		this.sellerID = sellerID;
		this.amount = amount;
		this.stoke = stoke;
		this.category = category;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public int getSellerID() {
		return sellerID;
	}

	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getStoke() {
		return stoke;
	}

	public void setStoke(int stoke) {
		this.stoke = stoke;
	}

	public CategoryModels getCategory() {
		return category;
	}

	public void setCategory(CategoryModels category) {
		this.category = category;
	}
}
