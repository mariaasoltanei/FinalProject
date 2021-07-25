package ro.scoalainformala.projectattempt1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DecideActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.decide_page);

        ImageButton imageFood = findViewById(R.id.image_food);
        ImageButton imageWorkout = findViewById(R.id.image_workout);

        imageFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openFood();
            }
        });

        imageWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openWorkout();
            }
        });

    }
    public void openFood() {
        Intent intentFood = new Intent(this, FoodActivity.class);
        startActivity(intentFood);
    }

    public void openWorkout() {
        Intent intentWorkout = new Intent(this, WorkoutActivity.class);
        startActivity(intentWorkout);
    }
}
