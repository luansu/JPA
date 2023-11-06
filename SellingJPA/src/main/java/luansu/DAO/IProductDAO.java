package luansu.DAO;

import java.util.List;

import luansu.models.ProductModels;

public interface IProductDAO {
	List<ProductModels> findAll();
	ProductModels findOne(int productID);
	
	void insert(ProductModels product);
	void update(ProductModels product);
	void delete(int productID);
}
