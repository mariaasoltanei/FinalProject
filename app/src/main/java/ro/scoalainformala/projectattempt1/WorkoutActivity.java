package ro.scoalainformala.projectattempt1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class WorkoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_page);

        Button buttonWorkoutsExplore = findViewById(R.id.explore);
        Button buttonBuildPlan = findViewById(R.id.build_plan);
        FloatingActionButton homeButton = findViewById(R.id.home_button);

        buttonBuildPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBuildPlan();
            }
        });

        buttonWorkoutsExplore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExploreWorkouts();
            }
        });
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeButton();
            }
        });
    }

    public void homeButton() {
        Intent intentHome = new Intent(this, FragmentMain.class);
        startActivity(intentHome);
    }

    public void openExploreWorkouts() {
        Intent intentExploreWorkouts = new Intent(this, ExploreWorkouts.class);
        startActivity(intentExploreWorkouts);
    }

    public void openBuildPlan() {
        Intent intentBuildPlan = new Intent(this, BuildPlanActivity.class);
        startActivity(intentBuildPlan);
    }
}
