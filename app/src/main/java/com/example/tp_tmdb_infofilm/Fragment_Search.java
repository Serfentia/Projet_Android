package com.example.tp_tmdb_infofilm;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class Fragment_Search extends Fragment {

    public Fragment_Search(){}

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.search_fragment, container, false);
        EditText edtName = (EditText) view.findViewById(R.id.edtSearch);
        Button mButton = (Button) view.findViewById(R.id.btnSearch);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = String.valueOf(edtName.getText());

                if(name != "")
                {
                    FragmentManager FMS = getParentFragmentManager();
                    FragmentTransaction FTS = FMS.beginTransaction();
                    FTS.replace(R.id.FragmentModel, new Fragment_SearchResult(v));
                    FTS.commit();
                }
            }
        });
        return view;
    }
}
/*
package com.example.tp_tmdb_infofilm;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Fragment_Search extends Fragment implements SearchView.OnQueryTextListener{

    SearchView editsearch;
    FilmsAdapter adapter;
    ListItemClickListener arraylist = new ListItemClickListener();

    public Fragment_Search(){}

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        // Pass results to ListViewAdapter Class
        adapter = new FilmsAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.search_fragment, container, false);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = String.valueOf(edtName.getText());

                if(name != "")
                {
                    FragmentManager FMS = getParentFragmentManager();
                    FragmentTransaction FTS = FMS.beginTransaction();
                    FTS.replace(R.id.FragmentModel, new Fragment_SearchResult(v));
                    FTS.commit();
                }
            }
        });
        return view;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }
}

 */