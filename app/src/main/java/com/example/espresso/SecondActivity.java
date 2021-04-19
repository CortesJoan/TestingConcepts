package com.example.espresso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    title= findViewById(R.id.activity_title);
    title.setText("Welcome back "+ getIntent().getStringExtra("username"));
    }

    @Override
    public void onBackPressed() {
        Intent intent  = new Intent(SecondActivity.this,MainActivity.class);
        startActivity(intent);
    }
}