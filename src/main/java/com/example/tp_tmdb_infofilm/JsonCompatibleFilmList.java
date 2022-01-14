package com.example.tp_tmdb_infofilm;

import java.util.List;

public class JsonCompatibleFilmList {

    private List<Film> JsonCompatibleList;

    public JsonCompatibleFilmList(List<Film> p_List)
    {
        this.JsonCompatibleList = p_List;
    }


    public List<Film> getJsonCompatibleList() {
        return JsonCompatibleList;
    }

}
