package fr.snapfood.service.Imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.snapfood.model.Category;
import fr.snapfood.repository.CategoryRepository;
import fr.snapfood.service.ICategoryService;

@Service
public class CategoryImpl implements ICategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public CategoryImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Optional<Category> getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public int deleteCategoryById(Integer id) {
        categoryRepository.deleteById(id);
        return 0;
    }

    @Override
    public void deleteCategoryByEntity(Category category) {
        categoryRepository.delete(category);
    }
}