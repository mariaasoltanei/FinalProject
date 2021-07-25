package ro.scoalainformala.projectattempt1;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WorkoutDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertWorkout(WorkoutItem workoutItem);

    @Query("DELETE FROM workout_items_table")
    void deleteAllWorkouts();

    @Query("SELECT * from workout_items_table ORDER BY workout_calories ASC")
    LiveData<List<WorkoutItem>> getOrderedWorkouts();

}
