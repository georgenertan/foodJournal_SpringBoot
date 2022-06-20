package itSchool.com.foodjournal.data;

import java.util.List;

public class Journal {
    private User user;
    private List<Food> food;

    public Journal(User user, List<Food> food) {
        this.user = user;
        this.food = food;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Food> getFood() {
        return food;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }
}
