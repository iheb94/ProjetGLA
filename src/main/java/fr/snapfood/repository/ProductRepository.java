package fr.snapfood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.snapfood.model.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
Iterable<Product> findAllByCategories(Integer c);
@Query("select p from Product p where p.categories.id =:x")
List<Product> GetProductByCat(@Param("x") int id);
}
