package com.example.tp_tmdb_infofilm;

import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;


public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder> {


    private final List<Film> mFilms;
    private final ListItemClickListener mOnClickListener;


    public FilmsAdapter(List<Film> mFilms, ListItemClickListener mOnClickListener) {
        this.mFilms = mFilms;
        this.mOnClickListener = mOnClickListener;
    }


    @NonNull
    @Override
    public FilmsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View PView = inflater.inflate(R.layout.film_item, parent, false);
        return new ViewHolder(PView);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmsAdapter.ViewHolder holder, int position) {
        Film film = mFilms.get(position);

        ImageView imageFilm = holder.imageFilm;
        Glide.with(imageFilm).load(film.getImage_path()).placeholder(R.drawable.ic_launcher_background).into(imageFilm);
    }

    @Override
    public int getItemCount() {
        return mFilms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView imageFilm;

        public ViewHolder (View iView)
        {
            super(iView);
            imageFilm = (ImageView) iView.findViewById(R.id.imageFilm);
            iView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            mOnClickListener.onListItemClick(position);
        }
    }

    public List<Film> getmFilms() {
        return mFilms;
    }
}
/*
package com.example.tp_tmdb_infofilm;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;


public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder> {


    private final List<Film> mFilms;
    private final ListItemClickListener mOnClickListener;
    Context mContext;
    private ArrayList<Film> arraylist;
    LayoutInflater mInflater;

    public FilmsAdapter(List<Film> films, ListItemClickListener OnClickListener){
        this.mFilms = films;
        this.mOnClickListener = OnClickListener;
    }


    public FilmsAdapter(Context context, List<Film> films, ListItemClickListener mOnClickListener) {
        mContext = context;
        this.mFilms = films;
        this.mOnClickListener = mOnClickListener;
        mInflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<>();
        this.arraylist.addAll(mFilms);
    }

    @NonNull
    @Override
    public FilmsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View PView = inflater.inflate(R.layout.film_item, parent, false);
        return new ViewHolder(PView);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmsAdapter.ViewHolder holder, int position) {
        Film film = mFilms.get(position);

        ImageView imageFilm = holder.imageFilm;
        Glide.with(imageFilm).load(film.getImage_path()).placeholder(R.drawable.ic_launcher_background).into(imageFilm);
    }

    @Override
    public int getItemCount() {
        return mFilms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView imageFilm;

        public ViewHolder (View iView)
        {
            super(iView);
            imageFilm = (ImageView) iView.findViewById(R.id.imageFilm);
            iView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            mOnClickListener.onListItemClick(position);
        }
    }

    public List<Film> getmFilms() {
        return mFilms;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        mFilms.clear();
        if (charText.length() == 0) {
            mFilms.addAll(arraylist);
        } else {
            for (Film f : arraylist) {
                if (f.getTitle().toLowerCase(Locale.getDefault()).contains(charText)) {
                    mFilms.add(f);
                }
            }
        }
        notifyDataSetChanged();
    }
}

 */
