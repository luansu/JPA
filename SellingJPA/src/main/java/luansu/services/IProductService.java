package luansu.services;

import java.util.List;

import luansu.models.ProductModels;

public interface IProductService {
	List<ProductModels> findAll();
	ProductModels findOne(int productID);
	
	void insert(ProductModels product);
	void update(ProductModels product);
	void delete(int productID);
}
