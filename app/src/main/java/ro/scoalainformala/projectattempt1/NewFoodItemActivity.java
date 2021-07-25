package ro.scoalainformala.projectattempt1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewFoodItemActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "ro.android.fooddatabase.EXTRA_NAME";
    public static final String EXTRA_BRAND = "ro.android.fooddatabase.EXTRA_BRAND";
    public static final String EXTRA_CALORIES = "ro.android.fooddatabase.EXTRA_CALORIES";
    public static final String EXTRA_QUANTITY = "ro.android.fooddatabase.EXTRA_QUANTITY";

    private  EditText editorFoodName;
    private  EditText editorFoodBrand;
    private  EditText editorFoodCalories;
    private  EditText editorFoodQuantity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_food_item);
        editorFoodName = findViewById(R.id.edit_food_name);
        editorFoodBrand = findViewById(R.id.edit_food_brand);
        editorFoodCalories = findViewById(R.id.edit_food_calorie);
        editorFoodQuantity = findViewById(R.id.edit_food_quantity);

        final Button button = findViewById(R.id.button_save_food);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(editorFoodName.getText()) || TextUtils.isEmpty(editorFoodBrand.getText()) || TextUtils.isEmpty(editorFoodCalories.getText()) || TextUtils.isEmpty(editorFoodQuantity.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String name = editorFoodName.getText().toString();
                    String brand = editorFoodBrand.getText().toString();
                    String calories = editorFoodCalories.getText().toString();
                    String quantity = editorFoodQuantity.getText().toString();
                    replyIntent.putExtra(EXTRA_NAME, name);
                    replyIntent.putExtra(EXTRA_BRAND, brand);
                    replyIntent.putExtra(EXTRA_CALORIES, calories);
                    replyIntent.putExtra(EXTRA_QUANTITY, quantity);

                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}