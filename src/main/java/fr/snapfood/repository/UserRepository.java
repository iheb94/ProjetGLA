package fr.snapfood.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.snapfood.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
List<User> findUserByEmailAndPassword(String email,String password);
Optional<User> findUserByEmail(String email);
}
