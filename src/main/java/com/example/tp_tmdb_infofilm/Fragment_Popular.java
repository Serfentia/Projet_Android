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

public class Fragment_Popular extends Fragment implements ListItemClickListener {
    private String key = "45bf6592c14a965b33549f4cc7e6c664";
    static List<Film> filmList = new ArrayList<>();
    private String language = "en-US";

    private String id_film;
    static int index;

    public Fragment_Popular(String lang){
        this.language = lang;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.popular_fragment, container, false);
        RecyclerView RVPop = (RecyclerView) view.findViewById(R.id.recycled_popular);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 2, LinearLayoutManager.VERTICAL, false);

        TMDB_Services TMDBserv = new Retrofit.Builder().baseUrl(TMDB_Services.ENDPOINT).addConverterFactory(GsonConverterFactory.create()).build().create(TMDB_Services.class);

        TMDBserv.popularRequest(key, language).enqueue(new Callback<JsonCompatibleFilmList>() {

            @Override
            public void onResponse(@NonNull Call<JsonCompatibleFilmList> call, @NonNull Response<JsonCompatibleFilmList> response) {
                filmList = response.body().getJsonCompatibleList();

                FilmsAdapter adapter = new FilmsAdapter(filmList, Fragment_Popular.this);
                RVPop.setAdapter(adapter);
                RVPop.setLayoutManager(gridLayoutManager);
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

        FragmentManager PopularFM = Fragment_Popular.this.getParentFragmentManager();
        FragmentTransaction PopularFT = PopularFM.beginTransaction();
        PopularFT.replace(R.id.FragmentModel, new Fragment_FilmDetails(film.getId(), language));
        PopularFT.commit();
        MainActivity.setTabIndex(4);
    }
}
