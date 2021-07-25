package ro.scoalainformala.projectattempt1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class BuildPlanActivity extends AppCompatActivity {
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    private WorkoutViewModel workoutViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.build_your_plan_page);

        RecyclerView recyclerView = findViewById(R.id.recyclerview_workout);
        final WorkoutListAdapter adapter = new WorkoutListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get a new or existing ViewModel from the ViewModelProvider.
        workoutViewModel = new ViewModelProvider(this).get(WorkoutViewModel.class);

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        workoutViewModel.getAllWorkoutItems().observe(this, new Observer<List<WorkoutItem>>() {
            @Override
            public void onChanged(@Nullable final List<WorkoutItem> workoutItems) {
                // Update the cached copy of the words in the adapter.
                adapter.setWorkoutItems(workoutItems);
            }
        });

        FloatingActionButton buttonAddWorkout = findViewById(R.id.button_add_workout);
        buttonAddWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentWorkout = new Intent(BuildPlanActivity.this, NewWorkoutItemActivity.class);
                startActivityForResult(intentWorkout, NEW_WORD_ACTIVITY_REQUEST_CODE);
            }
        });

        FloatingActionButton buttonHome = findViewById(R.id.home_button);

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeButton();
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            WorkoutItem workoutItem = new WorkoutItem(data.getStringExtra(NewWorkoutItemActivity.EXTRA_NAME_W),data.getStringExtra(NewWorkoutItemActivity.EXTRA_SETS),data.getStringExtra(NewWorkoutItemActivity.EXTRA_REPS),data.getStringExtra(NewWorkoutItemActivity.EXTRA_CALORIE));
            workoutViewModel.insertWorkout(workoutItem);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }

    public void homeButton() {
        Intent intentHome = new Intent(this, FragmentMain.class);
        startActivity(intentHome);
    }

}

