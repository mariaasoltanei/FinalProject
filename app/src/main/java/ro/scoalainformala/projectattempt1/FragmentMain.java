package ro.scoalainformala.projectattempt1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FragmentMain extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        FloatingActionButton mainButton = findViewById(R.id.main_button);
        TextView calorieGoalTV = findViewById(R.id.text_view_goal);

        ExtendedFloatingActionButton mainActivity = findViewById(R.id.main_activity);

        mainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity();
            }
        });

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainButton();
            }
        });
    }

    public void mainButton() {
        Intent intentHome = new Intent(this, DecideActivity.class);
        startActivity(intentHome);
    }
    public void mainActivity() {
        Intent intentMainActivity = new Intent(this, MainActivity.class);
        startActivity(intentMainActivity);
    }
}
