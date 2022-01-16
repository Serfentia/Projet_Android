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
    private String language;
    public Fragment_Search(String lang){
        this.language = lang;
    }

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
                    FTS.replace(R.id.FragmentModel, new Fragment_SearchResult(v,language));
                    FTS.commit();
                }
            }
        });
        return view;
    }
}