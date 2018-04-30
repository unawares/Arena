package com.example.theodore.arena;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.theodore.arena.models.User;

public class SplashScreen extends MyAppCompatActivity {

    private static final int SPLASH_SCREEN_DURATION = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final User user = new User();

        (new Handler()).postDelayed(new Thread() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getApplicationContext(), AuthActivity.class);
                        intent.putExtra(getResources().getString(R.string.user_key), user);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        }, SPLASH_SCREEN_DURATION);
    }
}
