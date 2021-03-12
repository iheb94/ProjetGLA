package fr.snapfood.service.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.snapfood.model.Product;
import fr.snapfood.repository.ProductRepository;
import fr.snapfood.service.IProductService;

@Service
public class ProductImpl implements IProductService {
    @Autowired
    ProductRepository productRepository;

    public ProductImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Iterable<Product> findAllByCategory(Integer category) {
        return productRepository.findAllByCategories(category);
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public int deleteProductById(Integer id) {
        productRepository.deleteById(id);
        return 0;
    }

    @Override
    public void deleteProductByEntity(Product product) {
        productRepository.delete(product);
    }

	@Override
	public List<Product> GetProductByCat(int id) {
		// TODO Auto-generated method stub
		return (List<Product>)productRepository.GetProductByCat(id);
	}
}