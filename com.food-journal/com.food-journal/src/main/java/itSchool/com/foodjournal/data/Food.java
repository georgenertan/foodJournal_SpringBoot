package itSchool.com.foodjournal.data;

import java.util.List;
import java.util.Objects;

public class Food {
    private static int idHelper = 0;
    private int id;
    private List<Ingredient> ingredients;
    private int calories;

    public Food(List<Ingredient> ingredients, int calories) {
        this.ingredients = ingredients;
        this.calories = calories;
        this.id = idHelper;
        idHelper++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return id == food.id && calories == food.calories && ingredients.equals(food.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ingredients, calories);
    }
}
