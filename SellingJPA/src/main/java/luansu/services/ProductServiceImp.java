package luansu.services;

import java.util.List;

import luansu.DAO.IProductDAO;
import luansu.DAO.ProductDAOImp;
import luansu.models.ProductModels;

public class ProductServiceImp implements IProductService{
	IProductDAO proDAO = new ProductDAOImp();
	@Override
	public List<ProductModels> findAll() {
		return proDAO.findAll();
	}

	@Override
	public ProductModels findOne(int productID) {
		return proDAO.findOne(productID);
	}

	@Override
	public void insert(ProductModels product) {
		proDAO.insert(product);
	}

	@Override
	public void update(ProductModels product) {
		proDAO.update(product);
	}

	@Override
	public void delete(int productID) {
		proDAO.delete(productID);
	}
}
