package itSchool.com.foodjournal.services;

import itSchool.com.foodjournal.data.Food;
import itSchool.com.foodjournal.models.FoodModel;
import itSchool.com.foodjournal.exceptions.ElementAlreadyExistsException;
import itSchool.com.foodjournal.exceptions.ElementDoesntExistException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FoodService {

    private final List<Food> foodList = new ArrayList<>();

    //POST
    public Food addFood(FoodModel foodModel) {
        Food food = new Food(foodModel.getIngredients(), foodModel.getCalories());
        if (foodList.contains(food)) {
            throw new ElementAlreadyExistsException("Food already exists!");
        }
        foodList.add(food);
        return food;
    }

    //PUT
    public Food modifyFood(FoodModel foodModel, int foodId) {
        Iterator<Food> iterator = foodList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == foodId) {
                iterator.next().setIngredients(foodModel.getIngredients());
                iterator.next().setCalories(foodModel.getCalories());
                return iterator.next();
            }
        }
        throw new ElementDoesntExistException("Food dosen't exist!");
    }

    public List<Food> getAllFoods() {
        return foodList;
    }

    public Food getFoodById(int foodId) {
        for (Food food : foodList) {
            if (food.getId() == foodId) {
                return food;
            }
        }
        throw new ElementDoesntExistException("Food dosen't exist!");
    }

    public Food deleteFood(int foodId) {
        for (Food food : foodList) {
            if (food.getId() == foodId) {
                foodList.remove(food);
                return food;
            }
        }
        throw new ElementDoesntExistException("Food dosen't exist!");
    }
}
