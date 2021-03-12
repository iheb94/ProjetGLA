package fr.snapfood.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.snapfood.model.User;
import fr.snapfood.service.IUserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserRest {
    
    @Autowired
    IUserService iUserService;

    public UserRest(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @GetMapping("/users")
    public Iterable<User> getAlluser() {
        Iterable<User> allUsers = iUserService.getAllUsers();
      
        return allUsers;
    }

    @GetMapping("/user/{id}")
    public Optional<User> getuser(@PathVariable(name = "id") int id) {
        return iUserService.getUserById(id);
    }

  

    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        return iUserService.updateUser(user);
    }

    @GetMapping("/user/{email}/{password}")
    public List<User> loginUser(@PathVariable(name = "email") String email, @PathVariable(name = "password") String password) {
        
        return ( List<User>)iUserService.findUsersByEmailAndPassword(email, password);
    }
    @GetMapping("/user/checkmail/{email}")
    public Optional<User> checkEmail(@PathVariable String email){
        return iUserService.checkEmail(email);
    }
}