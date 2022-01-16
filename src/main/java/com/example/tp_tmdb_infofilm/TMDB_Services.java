
package com.example.tp_tmdb_infofilm;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TMDB_Services {
    public static final String ENDPOINT = "https://api.themoviedb.org/";

    @GET("3/movie/popular")
    Call<JsonCompatibleFilmList> popularRequest(@Query("api_key") String api_key,@Query("language") String language);

    @GET("3/movie/upcoming")
    Call<JsonCompatibleFilmList> upcomingRequest(@Query("api_key") String api_key,@Query("language") String language);

    @GET("3/movie/{film_id}")
    Call<Film> getDetails(@Path("film_id") String film_id, @Query("api_key") String api_key, @Query("language") String language);

    @GET("3/search/movie")
    Call<JsonCompatibleFilmList> searchRequest(@Query("api_key") String api_key,@Query("language") String language, @Query("query") String nom);




}
