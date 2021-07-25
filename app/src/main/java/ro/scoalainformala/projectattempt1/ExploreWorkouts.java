package ro.scoalainformala.projectattempt1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ExploreWorkouts extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explore_workouts_page);
        WebView webViewWorkouts = (WebView) findViewById(R.id.webview_workouts);
        webViewWorkouts.loadUrl("https://www.healthline.com/health/fitness-exercise/at-home-workouts#beginner-routine");

    }

}
