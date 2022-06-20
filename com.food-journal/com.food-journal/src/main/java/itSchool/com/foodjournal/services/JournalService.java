package itSchool.com.foodjournal.services;

import itSchool.com.foodjournal.data.Food;
import itSchool.com.foodjournal.data.Journal;
import itSchool.com.foodjournal.exceptions.ElementAlreadyExistsException;
import itSchool.com.foodjournal.exceptions.ElementDoesntExistException;
import itSchool.com.foodjournal.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JournalService {
    @Autowired
    private UserService userService;
    @Autowired
    private FoodService foodService;
    private final List<Journal> journalList = new ArrayList<>();
    // a Journal has a User and a list of Foods

    public Journal createJournal(int userId) {
        User user = userService.getUserById(userId);     // check if the list of journals has the user
        if (journalList.contains(user)) {                // that has the Id == userId
            throw new ElementAlreadyExistsException("This user already has a journal");
        }                                                // if YES, throw an exception
        Journal journal = new Journal(user, new ArrayList<>());
        journalList.add(journal);                       // if NOT, the user is added to the list
        return journal;                                 // and an empty list(for food) is created for him
    }

    public Journal addFoodToUser(int userId, int foodId) {
        Food food = foodService.getFoodById(foodId);
        for (Journal journal : journalList) {               // check if the user is in the list of journals
            if (journal.getUser().getId() == userId) {      // if YES, check if his list of Foods has the
                if (journal.getFood().contains(food)) {     // food that has the Id == foodId
                    throw new ElementAlreadyExistsException("The user already has this type of food");
                }                                           // if YES, throw an exception
                journal.getFood().add(food);                // if NOT, the food is added to the list of journals
                return journal;
            }                                     // if the user is not in the list of journals
        }                                         // throw an exception
        throw new ElementDoesntExistException("User doesn't have a journal");
    }

    public Journal getJournalForUser(int userId) {
        User user = userService.getUserById(userId);        // check if the list of journals has the user
        for (Journal journal : journalList) {               // with the Id == userId
            if (journal.getUser().equals(user)) {           // if YES, the journal for that user it is returned
                return journal;
            }
        }                                                   // if NOT, throw an exception
        throw new ElementDoesntExistException("This user doesn't have a journal");
    }

    public Journal deleteFoodOfUser(int userId, int foodId) {
        User user = userService.getUserById(userId);
        Food food = foodService.getFoodById(foodId);
        for (Journal journal : journalList) {                  // like addFoodToUser
            if (journal.getUser().equals(user)) {              // but instead of adding the food to the list
                if (journal.getFood().contains(food)) {        // this one it is removed from the list
                    journal.getFood().remove(food);
                    return journal;
                } else {                              // if the food is not in the list an exception is thrown
                    throw new ElementDoesntExistException("User doesn't have this food");
                }
            }                                           // if the user is not in the list of journals
        }                                               // throw an exception
        throw new ElementDoesntExistException("This user doesn't have a journal");
    }

    public Journal deleteAllUserFoods(int userId) {
        User user = userService.getUserById(userId);        // check if the list of journals has the user
        for (Journal journal : journalList) {               // with the Id == userId
            if (journal.getUser().equals(user)) {           // if YES, the list of food is deleted,
                journal.setFood(new ArrayList<>());         // and a new one is created
                return journal;
            }                                   // if the user is not in the list of journals
        }                                       // throw an exception
        throw new ElementDoesntExistException("This user doesn't have a journal");
    }
}
