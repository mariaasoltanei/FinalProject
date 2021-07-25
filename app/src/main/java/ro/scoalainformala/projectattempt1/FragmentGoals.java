package ro.scoalainformala.projectattempt1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FragmentGoals extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goals_page);
        FloatingActionButton homeButton = findViewById(R.id.home_button);
        Button weightGoalButton = findViewById(R.id.weight_goal_btn);
        Button nutritionGoalButton = findViewById(R.id.nutrition_goal_btn);

        nutritionGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNutritionGoalPage();
            }
        });

        weightGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeightGoalPage();
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeButton();
            }
        });
    }

    private void openWeightGoalPage() {
        Intent weightGoalIntent = new Intent(this, WeightGoalActivity.class);
        startActivity(weightGoalIntent);
    }
    private void openNutritionGoalPage() {
        Intent nutritionGoalIntent = new Intent(this, NutritionGoalActivity.class);
        startActivity(nutritionGoalIntent);
    }

    public void homeButton() {
        Intent intentHome = new Intent(this, FragmentMain.class);
        startActivity(intentHome);
    }
}
