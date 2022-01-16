package com.example.tp_tmdb_infofilm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static int tabIndex = 1;
    private static int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void TabManager(int p_TabIndex)
    {
        tabIndex = p_TabIndex;

        FragmentManager FM  = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        switch(tabIndex)
        {
            case 1:
                FT.replace(R.id.FragmentModel, new Fragment_Popular());
                break;
            case 2:
                FT.replace(R.id.FragmentModel, new Fragment_Upcoming());
                break;
            case 3:
                FT.replace(R.id.FragmentModel, new Fragment_Search());
                break;

        }
        FT.commit();

        Button btnP = (Button) findViewById(R.id.btnPopular);
        Button btnU = (Button) findViewById(R.id.btnUpcoming);
        Button btnS = (Button) findViewById(R.id.btnSearch);


    }

    public void onPopClick(View V)
    {
        TabManager(1);
    }

    public void onUpClick(View V)
    {
        TabManager(2);
    }

    public void onSearchClick(View V)
    {
        TabManager(3);
    }
}