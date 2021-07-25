package ro.scoalainformala.projectattempt1;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "workout_items_table")
public class WorkoutItem {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "workout_name")
    private String workoutName;

    @NonNull
    @ColumnInfo(name = "workout_sets")
    private String workoutSets;

    @NonNull
    @ColumnInfo(name = "workout_reps")
    private String workoutReps;

    @NonNull
    @ColumnInfo(name = "workout_calories")
    private String workoutCalories;

    public WorkoutItem(@NonNull String workoutName, @NonNull String workoutSets, @NonNull String workoutReps, @NonNull String workoutCalories) {
        this.workoutName = workoutName;
        this.workoutSets = workoutSets;
        this.workoutReps = workoutReps;
        this.workoutCalories = workoutCalories;
    }

    @NonNull
    public String getWorkoutName() {
        return workoutName;
    }

    @NonNull
    public String getWorkoutSets() {
        return workoutSets;
    }

    @NonNull
    public String getWorkoutReps() {
        return workoutReps;
    }

    @NonNull
    public String getWorkoutCalories() {
        return workoutCalories;
    }
}
