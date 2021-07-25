package ro.scoalainformala.projectattempt1;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class FoodRepository {
    private FoodDao foodDao;
    private LiveData<List<FoodItem>> allFood;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    FoodRepository(Application application) {
        FoodRoomDatabase db = FoodRoomDatabase.getDatabase(application);
        foodDao = db.foodDao();
        allFood = foodDao.getOrderedFood();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<FoodItem>> getAllFoodItems() {
        return allFood;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insertRepoFood(FoodItem foodItem) {
        FoodRoomDatabase.databaseWriteExecutor.execute(() -> {
            foodDao.insertFood(foodItem);
        });
    }
}