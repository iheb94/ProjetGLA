package fr.snapfood.service;

import java.util.Optional;

import fr.snapfood.model.Category;

public interface ICategoryService {
	 Iterable<Category> getAllCategories();

	    Optional<Category> getCategoryById(Integer id);

	    Optional<Category> getCategoryByName(String name);
	    Category addCategory(Category category);

	    Category updateCategory(Category category);

	    int deleteCategoryById(Integer id);

	    void deleteCategoryByEntity(Category category);

}
