package fr.snapfood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.snapfood.model.Picture;
import fr.snapfood.model.Product;
@Repository
public interface PictureRepository extends CrudRepository<Picture, Integer>{
	@Query("select p from Picture p where p.products.id=:x ")
	Picture getpicbyproduct(@Param("x")int x);

}
