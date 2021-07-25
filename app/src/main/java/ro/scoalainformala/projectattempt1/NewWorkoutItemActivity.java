package ro.scoalainformala.projectattempt1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewWorkoutItemActivity extends AppCompatActivity {
    public static final String EXTRA_NAME_W = "ro.android.fooddatabase.EXTRA_NAME_W";
    public static final String EXTRA_SETS = "ro.android.fooddatabase.EXTRA_STES";
    public static final String EXTRA_REPS = "ro.android.fooddatabase.EXTRA_REPS";
    public static final String EXTRA_CALORIE = "ro.android.fooddatabase.EXTRA_CALORIE";

    private EditText editorWorkoutName;
    private  EditText editorWorkoutSets;
    private  EditText editorWorkoutReps;
    private  EditText editorWorkoutCalories;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_workout_item);
        editorWorkoutName= findViewById(R.id.edit_workout_name);
        editorWorkoutSets = findViewById(R.id.edit_workout_sets);
        editorWorkoutReps = findViewById(R.id.edit_workout_reps);
        editorWorkoutCalories = findViewById(R.id.edit_workout_calories);

        final Button buttonSaveWorkout = findViewById(R.id.button_save_workout);
        buttonSaveWorkout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntentWorkout = new Intent();
                if (TextUtils.isEmpty(editorWorkoutName.getText()) || TextUtils.isEmpty(editorWorkoutSets.getText()) || TextUtils.isEmpty(editorWorkoutReps.getText()) || TextUtils.isEmpty(editorWorkoutCalories.getText())) {
                    setResult(RESULT_CANCELED, replyIntentWorkout);
                } else {
                    String nameWorkout = editorWorkoutName.getText().toString();
                    String sets = editorWorkoutSets.getText().toString();
                    String reps = editorWorkoutReps.getText().toString();
                    String calorie = editorWorkoutCalories.getText().toString();
                    replyIntentWorkout.putExtra(EXTRA_NAME_W, nameWorkout);
                    replyIntentWorkout.putExtra(EXTRA_SETS, sets);
                    replyIntentWorkout.putExtra(EXTRA_REPS, reps);
                    replyIntentWorkout.putExtra(EXTRA_CALORIE, calorie);

                    setResult(RESULT_OK, replyIntentWorkout);
                }
                finish();
            }
        });
    }
}

