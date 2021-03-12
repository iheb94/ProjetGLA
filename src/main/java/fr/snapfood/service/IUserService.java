package fr.snapfood.service;

import java.util.List;
import java.util.Optional;

import fr.snapfood.model.User;

public interface IUserService {
	 Iterable<User> getAllUsers();

	    Optional<User> checkEmail(String email);

	    Optional<User> getUserById(Integer id);

	    List<User> findUsersByEmailAndPassword(String email, String password);

	    User addUser(User user);

	    User updateUser(User user);

	    void deleuserById(Integer id);

	    void deleUserByEntity(User user);

}
