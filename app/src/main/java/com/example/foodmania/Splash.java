package com.example.foodmania;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

// hide title bar



        Thread td = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(5000);

                } catch (Exception ex) {
                    ex.printStackTrace();

                } finally {
                    Intent intent = new Intent(Splash.this, RegisterActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }; td.start();
    }
    }
