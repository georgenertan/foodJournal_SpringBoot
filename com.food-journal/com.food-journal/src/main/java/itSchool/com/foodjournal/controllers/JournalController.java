package itSchool.com.foodjournal.controllers;

import itSchool.com.foodjournal.data.Journal;
import itSchool.com.foodjournal.services.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalService journalService;

    // POST  /{userId}
    @PostMapping("/{userId}")
    public Journal createUserJournal(@PathVariable int userId) {
        return journalService.createJournal(userId);
    }

    // POST  /{userId}/{foodId}
    @PostMapping("/{userId}/{foodId}")
    public Journal addFoodToUser(@PathVariable int userId, @PathVariable int foodId) {
        return journalService.addFoodToUser(userId, foodId);
    }

    // GET  /{userId}
    @GetMapping("/{userId}")
    public Journal getJournalForUser(@PathVariable int userId) {
        return journalService.getJournalForUser(userId);
    }

    //DELETE /{userId}/{foodId}
    @DeleteMapping("/{userId}/{foodId}")
    public Journal deleteFoodOfUser(@PathVariable int userId, @PathVariable int foodId) {
        return journalService.deleteFoodOfUser(userId, foodId);
    }

    //DELETE /{userId}
    @DeleteMapping("/{userId}")
    public Journal deleteAllUserFoods(@PathVariable int userId) {
        return journalService.deleteAllUserFoods(userId);
    }
}
