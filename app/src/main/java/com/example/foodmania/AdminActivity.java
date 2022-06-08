package com.example.foodmania;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AdminActivity extends AppCompatActivity {
ImageButton ins, up, del, sea ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


        ins = findViewById(R.id.insert);
        up = findViewById(R.id.update);
        del = findViewById(R.id.delete);
        sea = findViewById(R.id.search);


        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity.this, AddActivity.class);
                startActivity(i);
            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity.this, UpdateActivity.class);
                startActivity(i);
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity.this, DeleteActivity.class);
                startActivity(i);
            }
        });

        sea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity.this, SearchActivity.class);
                startActivity(i);
            }
        });
    }
}