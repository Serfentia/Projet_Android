package com.example.tp_tmdb_infofilm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment_SearchResult extends Fragment implements ListItemClickListener {
    private static final String key = "55542293051c3724af4d8f8259c17ad4";
    static List<Film> filmList = new ArrayList<>();

    View view;
    public String nom;


    private String id_film;
    static int index;

    public Fragment_SearchResult(View v){
        view = v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 2, LinearLayoutManager.VERTICAL, false);
        View view = inflater.inflate(R.layout.searchresult_fragment, container, false);
        RecyclerView RVSRes = (RecyclerView) view.findViewById(R.id.recycled_result);

        TMDB_Services TMDBServ = new Retrofit.Builder().baseUrl(TMDB_Services.ENDPOINT).addConverterFactory(GsonConverterFactory.create()).build().create(TMDB_Services.class);

        TMDBServ.searchRequest(key, nom).enqueue(new Callback<JsonCompatibleFilmList>() {

            @Override
            public void onResponse(Call<JsonCompatibleFilmList> call, Response<JsonCompatibleFilmList> response) {
                for(Film film : response.body().getJsonCompatibleList())
                {
                    filmList.add(new Film(film.getImage_path(), film.getTitle(), film.getId()));
                }

                FilmsAdapter adapter = new FilmsAdapter(filmList, Fragment_SearchResult.this);
                RVSRes.setAdapter(adapter);
                RVSRes.setLayoutManager(gridLayoutManager);
            }

            @Override
            public void onFailure(Call<JsonCompatibleFilmList> call, Throwable t) {

            }
        });

        return view;
    }

    @Override
    public void onListItemClick(int index) {
        Film film = filmList.get(index);

        FragmentManager SearchFM = Fragment_SearchResult.this.getParentFragmentManager();
        FragmentTransaction SearchFT = SearchFM.beginTransaction();
        SearchFT.replace(R.id.FragmentModel, new Fragment_FilmDetails(film.getId()));
        SearchFT.commit();
    }
}
