package com.example.theodore.arena;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.theodore.arena.models.User;

public class RegistrationActivity extends MyAppCompatActivity {

    User user;
    ImageView backgroundImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        init();
    }

    private void init() {
        Intent intent = getIntent();
        if (intent.hasExtra(getResources().getString(R.string.user_key))) {
            user = intent.getParcelableExtra(getResources().getString(R.string.user_key));
        }
        backgroundImageView = findViewById(R.id.background_image_view);
        Glide.with(this).load(R.drawable.auth_background).clone().into(backgroundImageView);
    }
}
