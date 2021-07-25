package ro.scoalainformala.projectattempt1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WorkoutListAdapter extends RecyclerView.Adapter<WorkoutListAdapter.WorkoutViewHolder> {
    public class WorkoutViewHolder extends RecyclerView.ViewHolder {
        private final TextView workoutNameTV;
        private final TextView workoutRepsTV;
        private final TextView workoutSetsTV;
        private final TextView workoutCaloriesTV;


        public WorkoutViewHolder(@NonNull View itemView) {
            super(itemView);
            this.workoutNameTV = itemView.findViewById(R.id.workout_name);
            this.workoutRepsTV = itemView.findViewById(R.id.workout_reps);
            this.workoutSetsTV = itemView.findViewById(R.id.workout_sets);
            this.workoutCaloriesTV = itemView.findViewById(R.id.workout_calories);
        }
    }

    private final LayoutInflater mWorkoutInflater;
    private List<WorkoutItem> mWorkoutItems; // Cached copy of words

    WorkoutListAdapter(Context context) { mWorkoutInflater = LayoutInflater.from(context); }

    public WorkoutViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mWorkoutInflater.inflate(R.layout.workout_item, parent, false);
        return new WorkoutViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WorkoutViewHolder holder, int position) {
        if (mWorkoutItems != null) {
            WorkoutItem current = mWorkoutItems.get(position);
            holder.workoutNameTV.setText(current.getWorkoutName());
            holder.workoutRepsTV.setText(current.getWorkoutReps());
            holder.workoutSetsTV.setText(current.getWorkoutSets());
            holder.workoutCaloriesTV.setText(current.getWorkoutCalories());
        } else {
            // Covers the case of data not being ready yet.
            holder.workoutNameTV.setText("No Word");
            holder.workoutRepsTV.setText("No Word");
            holder.workoutSetsTV.setText("No Word");
            holder.workoutCaloriesTV.setText("No Word");
        }
    }

    void setWorkoutItems(List<WorkoutItem> workouts){
        mWorkoutItems = workouts;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mWorkoutItems != null)
            return mWorkoutItems.size();
        else return 0;
    }
}
