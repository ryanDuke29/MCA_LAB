package com.rest.api.Model;

import lombok.Data;

@Data
public class Movies {
    private Integer id;
    private String name;
    private String genre;
    private Double rating;

    public Movies() {
    }

    public Movies(Integer id, String name, String genre, Double rating) {
        this.genre = genre;
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

}
