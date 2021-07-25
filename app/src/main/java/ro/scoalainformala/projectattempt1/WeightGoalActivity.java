package ro.scoalainformala.projectattempt1;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class WeightGoalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_goal_page);

        FloatingActionButton homeButton = findViewById(R.id.home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeButton();
            }
        });

        EditText currentWeight =findViewById(R.id.current_weight_change);
        String currentWeightText = currentWeight.getText().toString();
        int currentWeightInt = Integer.parseInt(currentWeightText);

        EditText goalWeight = findViewById(R.id.goal_weight_change);
        String goalWeightText = goalWeight.getText().toString();
        int goalText = Integer.parseInt(goalWeightText);


        ProgressBar weightProgressBar = findViewById(R.id.weightProgressBar);
        weightProgressBar.setMax(goalText);
        weightProgressBar.setProgress(currentWeightInt-goalText);

//        goalWeight.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                weightProgressBar.setMax(goalText);
//                weightProgressBar.setProgress(currentWeightInt-goalText);
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });

    }
    public void homeButton() {
        Intent intentHome = new Intent(this, FragmentMain.class);
        startActivity(intentHome);
    }
}
