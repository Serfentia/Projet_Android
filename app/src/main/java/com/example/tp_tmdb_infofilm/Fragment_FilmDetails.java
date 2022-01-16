package com.example.tp_tmdb_infofilm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment_FilmDetails extends Fragment {
    private String key = "55542293051c3724af4d8f8259c17ad4";
    private String language = "en-US";
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
    String id;

    private String id_film;
    static int index;

    public Fragment_FilmDetails(){

    }

    public Fragment_FilmDetails(String p_id, String lang){
        this.id = p_id;
        this.language = lang;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 2, LinearLayoutManager.VERTICAL, false);
        View view = inflater.inflate(R.layout.filmdetail_fragment, container, false);

        TMDB_Services TMDBserv = new Retrofit.Builder().baseUrl(TMDB_Services.ENDPOINT).addConverterFactory(GsonConverterFactory.create()).build().create(TMDB_Services.class);

        TMDBserv.getDetails(id, key, language).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                Film mFilm = response.body();

                Film film = new Film(mFilm.getImage_path(), mFilm.getId(), mFilm.getTitle(), mFilm.getDate_release(), mFilm.getSummary());

                ImageView imageFilm = view.findViewById(R.id.ImageFilm);
                Glide.with(imageFilm).load(film.getImage_path()).placeholder(R.drawable.ic_launcher_background).into(imageFilm);
                TextView title = view.findViewById(R.id.TxtTitle);
                title.setText(film.getTitle());
                TextView ReleaseDate = view.findViewById(R.id.TxtDate);
                ReleaseDate.setText(film.getDate_release());
                TextView desc = view.findViewById(R.id.TxtDesc);
                desc.setText(film.getSummary());

            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {

            }
        });

        return view;
    }

}
