package fr.snapfood.service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.snapfood.model.User;
import fr.snapfood.repository.UserRepository;
import fr.snapfood.service.IUserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserImpl implements IUserService {
    @Autowired
    UserRepository userRepository;

    public UserImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> checkEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findUsersByEmailAndPassword(String email, String password) {
        return (List<User>) userRepository.findUserByEmailAndPassword(email, password);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleuserById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleUserByEntity(User user) {
        userRepository.delete(user);
    }
}