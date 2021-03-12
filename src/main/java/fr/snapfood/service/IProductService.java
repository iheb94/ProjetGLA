package fr.snapfood.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import fr.snapfood.model.Product;

public interface IProductService {
	 Iterable<Product> getAllProducts();

	    Iterable<Product> findAllByCategory(Integer category);

	    Optional<Product> getProductById(Integer id);

	    Product addProduct(Product product);

	    Product updateProduct(Product product);

	    int deleteProductById(Integer id);

	    void deleteProductByEntity(Product product);
	    
	    List<Product> GetProductByCat( int id);

}
