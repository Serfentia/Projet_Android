package com.example.tp_tmdb_infofilm;

public class Film {

    final static String path_Posters = "https://image.tmdb.org/t/p/w500";

    public String image_path;
    public String id;
    public String date_release;
    public String title;
    public String summary;

    public Film(String p_path, String p_id, String p_title)
    {
        this.image_path = this.path_Posters+p_path;
        this.id = p_id;
        this.title = title;
    }

    public Film(String p_path, String p_id, String p_title, String p_date, String p_sum)
    {
        this.image_path = this.path_Posters+p_path;
        this.id = p_id;
        this.title = p_title;
        this.date_release = p_date;
        this.summary = p_sum;
    }

    //region Getter-Setters

    public String getDate_release() {
        return date_release;
    }

    public void setDate_release(String date_release) {
        this.date_release = date_release;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //endregion
}
