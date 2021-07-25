package ro.scoalainformala.projectattempt1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;

import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    private FoodViewModel foodViewModel;
    FoodListAdapter foodListAdapter;
    RecyclerView foodRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_page);

        foodRecyclerView = findViewById(R.id.recyclerview_food);
        foodListAdapter = new FoodListAdapter(this);
        foodRecyclerView.setAdapter(foodListAdapter);
        foodRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get a new or existing ViewModel from the ViewModelProvider.
        foodViewModel = new ViewModelProvider(this).get(FoodViewModel.class);

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        foodViewModel.getAllFoodItems().observe(this, new Observer<List<FoodItem>>() {
            @Override
            public void onChanged(@Nullable final List<FoodItem> foodItems) {
                // Update the cached copy of the words in the adapter.
                foodListAdapter.setFoodItems(foodItems);
            }
        });

        FloatingActionButton buttonAddFood = findViewById(R.id.button_add_food);
        buttonAddFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FoodActivity.this, NewFoodItemActivity.class);
                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
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
            FoodItem foodItem = new FoodItem(data.getStringExtra(NewFoodItemActivity.EXTRA_NAME),data.getStringExtra(NewFoodItemActivity.EXTRA_BRAND),data.getStringExtra(NewFoodItemActivity.EXTRA_CALORIES),data.getStringExtra(NewFoodItemActivity.EXTRA_QUANTITY));
            foodViewModel.insertFood(foodItem);
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
