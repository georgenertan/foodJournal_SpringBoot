package itSchool.com.foodjournal.services;

import itSchool.com.foodjournal.exceptions.ElementAlreadyExistsException;
import itSchool.com.foodjournal.exceptions.ElementDoesntExistException;
import itSchool.com.foodjournal.data.User;
import itSchool.com.foodjournal.models.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> usersList = new ArrayList<>();

    public User addUser(UserModel userModel) {
        User user = new User(userModel.getEmail(), userModel.getPassword());
        if (usersList.contains(user)) {
            throw new ElementAlreadyExistsException("This user already exists!");  //TODO change contains with equals emails
        } else {
            usersList.add(user);
            return user;
        }
    }

    public List<User> getAllUsers() {
        return usersList;
    }

    public User getUserById(int userId) {
        for (User user : usersList) {
            if (user.getId() == userId) {
                return user;
            }
        }
        throw new ElementDoesntExistException("User doesn't exist!");
    }

    public User deleteUser(int userId) {
        for (User user : usersList) {
            if (user.getId() == userId) {
                usersList.remove(user);
                return user;
            }
        }
        throw new ElementDoesntExistException("User doesn't exist!");
    }
}
