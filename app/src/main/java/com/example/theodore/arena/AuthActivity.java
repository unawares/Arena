package com.example.theodore.arena;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.theodore.arena.models.User;

import java.util.HashSet;

public class AuthActivity extends MyAppCompatActivity implements Button.OnClickListener {

    ImageView backgroundImageView;
    User user;

    Button registerButton;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        init();
    }

    private void init() {
        Intent intent = getIntent();
        if (intent.hasExtra(getResources().getString(R.string.user_key))) {
            user = intent.getParcelableExtra(getResources().getString(R.string.user_key));
        }
        backgroundImageView = findViewById(R.id.background_image_view);
        Glide.with(this).load(R.drawable.auth_background).clone().into(backgroundImageView);
        registerButton = findViewById(R.id.register_button);
        loginButton = findViewById(R.id.login_button);
        registerButton.setOnClickListener(this);
        loginButton.setOnClickListener(this);
    }

    private void onLoginClick() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        intent.putExtra(getResources().getString(R.string.user_key), user);
        startActivity(intent);
    }

    private void onRegisterClick() {
        Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
        intent.putExtra(getResources().getString(R.string.user_key), user);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_button:
                onRegisterClick();
                break;
            case R.id.login_button:
                onLoginClick();
                break;
        }
    }
}
