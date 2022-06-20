package itSchool.com.foodjournal.models;

import itSchool.com.foodjournal.data.Ingredient;

import java.util.List;

public class FoodModel {
    private List<Ingredient> ingredients;
    private int calories;

    public FoodModel(List<Ingredient> ingredients, int calories) {
        this.ingredients = ingredients;
        this.calories = calories;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
