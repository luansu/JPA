package luansu.services;

import java.util.List;

import luansu.DAO.CategoryDAOImp;
import luansu.DAO.ICategoryDAO;
import luansu.entity.Category;

public class CategoryServiceImp implements ICategoryService{
	ICategoryDAO cateDAO = new CategoryDAOImp();
	public List<Category> findAll() {
		return cateDAO.findAll();
	}
	
	public List<Category> findAll(int page, int pageSize) {
		return cateDAO.findAll(page, pageSize);
	}
	
	public List<Category> findByCategoryName(String categoryName) {
		return cateDAO.findByCategoryName(categoryName);
	}
	
	public Category findOne(int cateID) {
		return cateDAO.findOne(cateID);
	}
	
	public void insert(Category category) {
		cateDAO.insert(category);
	}
	
	public void update(Category category) {
		cateDAO.update(category);
	}

	public void delete(int categoryID) throws Exception{
		cateDAO.delete(categoryID);
	}
	
	public int count() {
		return cateDAO.count();
	}
}
