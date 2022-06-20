package itSchool.com.foodjournal.controllers;

import itSchool.com.foodjournal.data.Food;
import itSchool.com.foodjournal.models.FoodModel;
import itSchool.com.foodjournal.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    //POST /foods
    @PostMapping
    public Food addFood(@RequestBody FoodModel foodModel) {
        return foodService.addFood(foodModel);
    }

    //PUT /foods{foodId}
    @PutMapping("/{foodId}")
    public Food updateFood(@RequestBody FoodModel foodModel, @PathVariable int foodId) {
        return foodService.modifyFood(foodModel, foodId);
    }

    //GET /foods
    @GetMapping
    public List<Food> gedAllFoods() {
        return foodService.getAllFoods();
    }

    //GET /foods/{foodId}
    @GetMapping("/{foodId}")
    public Food getFoodById(@PathVariable int foodId) {
        return foodService.getFoodById(foodId);
    }

    //DELETE /foods/{foodId}
    @DeleteMapping("/{foodId}")
    public Food deleteFood(@PathVariable int foodId) {
        return foodService.deleteFood(foodId);
    }

}
