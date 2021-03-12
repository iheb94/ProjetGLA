package fr.snapfood.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import fr.snapfood.model.Category;
import fr.snapfood.service.ICategoryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CategoryRest {
    private static final Logger log = LoggerFactory.getLogger(CategoryRest.class);
    @Autowired
    ICategoryService iCategoryService;

    public CategoryRest(ICategoryService iCategoryService) {
        this.iCategoryService = iCategoryService;
    }

    @GetMapping("categories")
    public Iterable<Category> getAll() {
        return iCategoryService.getAllCategories();
    }

    @GetMapping("category/{id}")
    public Optional<Category> getCategoryById(@PathVariable(name = "id") int id) {
        return iCategoryService.getCategoryById(id);
    }

    @PostMapping("category")
    public Category addCategory(@RequestBody Category category) {
        return iCategoryService.addCategory(category);
    }

    @PutMapping("category")
    public Category updateCategory(@RequestBody Category category) {
        return iCategoryService.updateCategory(category);
    }

    @DeleteMapping("category/{id}")
    public int deleteCategory(@PathVariable int id){
        return iCategoryService.deleteCategoryById(id);
    }

}