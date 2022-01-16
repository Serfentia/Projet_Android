package com.example.tp_tmdb_infofilm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.ImageButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static int tabIndex = 1;
    private static int index;
    private String language ="en-US";
    public static void setTabIndex(int i) {
        tabIndex = i;
    }

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
                FT.replace(R.id.FragmentModel, new Fragment_Popular(language));
                break;
            case 2:
                FT.replace(R.id.FragmentModel, new Fragment_Upcoming(language));
                break;
            case 3:
                FT.replace(R.id.FragmentModel, new Fragment_Search(language));
                break;

        }
        FT.commit();

        ImageButton btnP = (ImageButton) findViewById(R.id.btnPopular);
        ImageButton btnU = (ImageButton) findViewById(R.id.btnUpcoming);
        ImageButton btnS = (ImageButton) findViewById(R.id.btnSearch);
        Button btnFR = (Button) findViewById(R.id.btnFR);
        Button btnEN = (Button) findViewById(R.id.btnEN);


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

    public void onENClick(View V) { language = "en-US";
        TabManager(tabIndex);}

    public void onFRClick(View V) {
        language = "fr-FR";
        TabManager(tabIndex);
    }

}