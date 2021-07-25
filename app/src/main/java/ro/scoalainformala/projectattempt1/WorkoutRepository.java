package ro.scoalainformala.projectattempt1;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WorkoutRepository {
    private WorkoutDao workoutDao;
    private LiveData<List<WorkoutItem>> allWorkouts;

    WorkoutRepository(Application application) {
        WorkoutRoomDatabase dbWorkout = WorkoutRoomDatabase.getDatabase(application);
        workoutDao = dbWorkout.workoutDao();
        allWorkouts = workoutDao.getOrderedWorkouts();
    }

    LiveData<List<WorkoutItem>> getAllWorkoutItems() {
        return allWorkouts;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insertRepoWorkout(WorkoutItem workoutItem) {
        WorkoutRoomDatabase.databaseWriteExecutor.execute(() -> {
            workoutDao.insertWorkout(workoutItem);
        });
    }


}
