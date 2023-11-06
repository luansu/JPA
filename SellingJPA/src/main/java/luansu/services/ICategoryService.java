package luansu.services;

import java.util.List;

import luansu.entity.Category;

public interface ICategoryService {
	List<Category> findAll();
	List<Category> findAll(int page, int pageSize);
	List<Category> findByCategoryName(String categoryName);
	Category findOne(int categoryID);
	
	void insert(Category category);
	void update(Category category);
	void delete(int categoryID) throws Exception;
	int count();
}
