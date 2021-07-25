package ro.scoalainformala.projectattempt1;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WorkoutViewModel extends AndroidViewModel {

    private WorkoutRepository workoutRepository;

    private LiveData<List<WorkoutItem>> allWorkouts;

    public WorkoutViewModel (Application application) {
        super(application);
        workoutRepository = new WorkoutRepository(application);
        allWorkouts = workoutRepository.getAllWorkoutItems();
    }

    LiveData<List<WorkoutItem>> getAllWorkoutItems() { return allWorkouts; }

    public void insertWorkout(WorkoutItem workoutItem) { workoutRepository.insertRepoWorkout(workoutItem); }

}
