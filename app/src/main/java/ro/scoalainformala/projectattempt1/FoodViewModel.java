package ro.scoalainformala.projectattempt1;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class FoodViewModel extends AndroidViewModel {
    private FoodRepository foodRepository;

    private LiveData<List<FoodItem>> allFood;

    public FoodViewModel (Application application) {
        super(application);
        foodRepository = new FoodRepository(application);
        allFood = foodRepository.getAllFoodItems();
    }

    LiveData<List<FoodItem>> getAllFoodItems() { return allFood; }

    public void insertFood(FoodItem foodItem) { foodRepository.insertRepoFood(foodItem); }
}