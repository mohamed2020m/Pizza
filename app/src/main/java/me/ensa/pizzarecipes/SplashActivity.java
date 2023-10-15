package me.ensa.pizzarecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import me.ensa.pizzarecipes.ui.ListPizzaActivity;

public class SplashActivity extends AppCompatActivity {

    private ImageView image;
    private ProgressBar progressBar;
    private Handler handler = new Handler(Looper.getMainLooper());
    private int progressIncrement = 2; // adjust the increment based on your desired smoothness
    private int totalTimeMillis = 1500;
    private int currentProgress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        image = findViewById(R.id.image);
        progressBar = findViewById(R.id.progressBar2);

        Animation rotation = AnimationUtils.loadAnimation(this, R.anim.shake);
        image.startAnimation(rotation);

        // Calculate the delay between each progress update
        long delay = totalTimeMillis / (100 / progressIncrement);
        // Start updating progress
        updateProgress(delay);

        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent intent = new Intent(SplashActivity.this, ListPizzaActivity.class);
                    startActivity(intent);
                    SplashActivity.this.finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }

    private void updateProgress(long delay) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (currentProgress < 100) {
                    currentProgress += progressIncrement;
                    progressBar.setProgress(currentProgress);
                    updateProgress(delay);
                }
            }
        }, delay);
    }
}