package luansu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import luansu.models.ProductModels;

public class ProductDAOImp implements IProductDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<ProductModels> findAll() {
		List<ProductModels> listPro = new ArrayList<ProductModels>();
		String sql = "SELECT * FROM Product";
		try {
			conn = DBConnectionSQLServer.getConnectionW();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductModels prod = new ProductModels();
				prod.setProductID(rs.getInt("productID"));
				prod.setProductName(rs.getString("ProductName"));
				prod.setDescription(rs.getString("description"));
				prod.setPrice(rs.getInt("price"));
				prod.setImageLink(rs.getString("imageLink"));
				prod.setCategoryID(rs.getInt("categoryID"));
				prod.setSellerID(rs.getInt("sellerID"));
				prod.setAmount(rs.getInt("amount"));
				prod.setStoke(rs.getInt("stoke"));
				listPro.add(prod);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return listPro;
	}
	
	public ProductModels findOne(int productID) {
		ProductModels prod = new ProductModels();
		String sql = "SELECT * FROM Product WHERE productID = ?";
		try {
			conn = DBConnectionSQLServer.getConnectionW();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, productID);
			rs = ps.executeQuery();
			rs.next();
			prod.setProductID(rs.getInt("productID"));
			prod.setProductName(rs.getString("categoryName"));
			prod.setDescription(rs.getString("description"));
			prod.setPrice(rs.getInt("price"));
			prod.setImageLink(rs.getString("imageLink"));
			prod.setCategoryID(rs.getInt("categoryID"));
			prod.setSellerID(rs.getInt("sellerID"));
			prod.setAmount(rs.getInt("amount"));
			prod.setStoke(rs.getInt("stoke"));
			conn.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return prod;
	}

	public void insert(ProductModels product) {
		String sql = "INSERT INTO Product(productName, description, price, imageLink, categoryID, sellerID, amount, stoke) VALUES(?,?,?,?,?,?,?,?)";
		try {
			conn = DBConnectionSQLServer.getConnectionW();
			ps = conn.prepareStatement(sql);
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getDescription());
			ps.setInt(3, product.getPrice());
			ps.setString(4, product.getImageLink());
			ps.setInt(5, product.getCategory().getCateID());
			ps.setInt(6, product.getSellerID());
			ps.setInt(7, product.getAmount());
			ps.setInt(8, product.getStoke());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void update(ProductModels product) {
		String sql = "UPDATE Product SET productName = ?, description = ?, price = ?, imageLink = ?, categoryID = ?, sellerID = ?, amount = ?, stoke = ? WHERE productID = ?";
		try {
			conn = DBConnectionSQLServer.getConnectionW();
			ps = conn.prepareStatement(sql);
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getDescription());
			ps.setInt(3, product.getPrice());
			ps.setString(4, product.getImageLink());
			ps.setInt(5, product.getCategory().getCateID());
			ps.setInt(6, product.getSellerID());
			ps.setInt(7, product.getAmount());
			ps.setInt(8, product.getStoke());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void delete(int productID) {
		String sql = "DELETE Product Where productID = ?";
		try {
			conn = DBConnectionSQLServer.getConnectionW();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, productID);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
}
