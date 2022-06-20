package itSchool.com.foodjournal.controllers;

import itSchool.com.foodjournal.data.User;
import itSchool.com.foodjournal.models.UserModel;
import itSchool.com.foodjournal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //POST /users
    @PostMapping
    public User addUser(@RequestBody UserModel userModel) {
        return userService.addUser(userModel);
    }

    //GET /users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //GET /users/{userId}
    @GetMapping("/{userId}")
    public User getUser(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    //DELETE /users/{usreId}
    @DeleteMapping("/{userId}")
    public User deleteUser(@PathVariable int userId) {
        return userService.deleteUser(userId);
    }


}
