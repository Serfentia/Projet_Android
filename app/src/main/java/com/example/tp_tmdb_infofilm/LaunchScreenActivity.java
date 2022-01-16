package com.example.tp_tmdb_infofilm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LaunchScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);

    }

    protected void onLauncher(View vue) {
        ImageView logoLaunch = findViewById(R.id.logoLaunchScreen);

        Button kontinuh = findViewById(R.id.btnLaunch);

        kontinuh.setOnClickListener(vue.setOnClickListener()

                ;);

        Intent launch = new Intent(this,MainActivity.class);
        startActivity(launch);
        this.finish();
        )};
    }
}