
package com.example.tp_tmdb_infofilm;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TMDB_Services {
    public static final String ENDPOINT = "https://api.themoviedb.org";

    @GET("/3/movie/popular")
    Call<List<Film>> popularRequest(@Query("api_key") String api_key);

    @GET("/3/movie/upcoming")
    Call<List<Film>> upcomingRequest(@Query("api_key") String api_key);

    @GET("/3/movie/{movie_id}")
    Call<Film> getDetails(@Path("film_id") String movie_id, @Query("api_key") String api_key);

    @GET("/3/search/movie")
    Call<List<Film>> searchRequest(@Query("api_key") String api_key, @Query("query") String query);




}
