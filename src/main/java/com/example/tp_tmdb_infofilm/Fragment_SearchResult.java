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
    static List<Film> filmList = new List<Film>() {
        //region Interface List Declaration
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(@Nullable Object o) {
            return false;
        }

        @NonNull
        @Override
        public Iterator<Film> iterator() {
            return null;
        }

        @NonNull
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @NonNull
        @Override
        public <T> T[] toArray(@NonNull T[] a) {
            return null;
        }

        @Override
        public boolean add(Film film) {
            return false;
        }

        @Override
        public boolean remove(@Nullable Object o) {
            return false;
        }

        @Override
        public boolean containsAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(@NonNull Collection<? extends Film> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, @NonNull Collection<? extends Film> c) {
            return false;
        }

        @Override
        public boolean removeAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Film get(int index) {
            return null;
        }

        @Override
        public Film set(int index, Film element) {
            return null;
        }

        @Override
        public void add(int index, Film element) {

        }

        @Override
        public Film remove(int index) {
            return null;
        }

        @Override
        public int indexOf(@Nullable Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(@Nullable Object o) {
            return 0;
        }

        @NonNull
        @Override
        public ListIterator<Film> listIterator() {
            return null;
        }

        @NonNull
        @Override
        public ListIterator<Film> listIterator(int index) {
            return null;
        }

        @NonNull
        @Override
        public List<Film> subList(int fromIndex, int toIndex) {
            return null;
        }
        //endregion
    };

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

        TMDBServ.searchRequest(key, nom).enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {

                for(Film film : response.body())
                {
                    filmList.add(new Film(film.getImage_path(), film.getTitle(), film.getId()));
                }

                FilmsAdapter adapter = new FilmsAdapter(filmList, Fragment_SearchResult.this);
                RVSRes.setAdapter(adapter);
                RVSRes.setLayoutManager(gridLayoutManager);

            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {

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
