package ro.scoalainformala.projectattempt1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NutritionGoalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nutrition_goal_page);

        FloatingActionButton homeButton = findViewById(R.id.home_button);
        FloatingActionButton saveNutritionGoalsButton = findViewById(R.id.save_nutrition_goals);
        TextView inputCalories = findViewById(R.id.nutr_calories_change);
        EditText inputCarbs = findViewById(R.id.nutr_carbs_change);
        EditText inputProtein = findViewById(R.id.nutr_protein_change);
        EditText inputFats = findViewById(R.id.nutr_fat_change);

//        inputCalories.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                Intent intentDialo
//                return false;
//            }
//        });

    //dialogs -> EditText->updateTextView

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeButton();
            }
        });

        //the number of calories must not be larger that 4*grams carbs+4*grams protein+9* grams fat
        //maybe use number picker for carbs, protein and fats
    }

    public void homeButton() {
        Intent intentHome = new Intent(this, FragmentMain.class);
        startActivity(intentHome);
    }


}
