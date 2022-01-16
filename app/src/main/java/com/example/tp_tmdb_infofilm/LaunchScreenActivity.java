package com.example.tp_tmdb_infofilm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class LaunchScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);
        Button kontinuh = findViewById(R.id.btnLaunch);
        kontinuh.setOnClickListener(v -> onLauncher(v));

    }

    protected void onLauncher(View vue) {
        Intent launch = new Intent(this,MainActivity.class);
        startActivity(launch);
        this.finish();

    }
}