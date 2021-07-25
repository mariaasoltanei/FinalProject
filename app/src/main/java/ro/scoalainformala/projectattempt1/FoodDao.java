package ro.scoalainformala.projectattempt1;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertFood(FoodItem foodItem);

    @Query("DELETE FROM food_items_table")
    void deleteAll();

    @Query("SELECT * from food_items_table ORDER BY food_calories ASC")
    LiveData<List<FoodItem>> getOrderedFood();
}
