package com.company.models;

import com.company.utils.enums.Genre;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Movie {

    private static final AtomicInteger count = new AtomicInteger(0);
    public Integer id;
    private String name;
    private Integer yearOfRelease;
    private Genre genre;
    private Double avgRating = 0.0;

    public Movie(){
        this.id = count.incrementAndGet();
    }

    public Movie(String name, Integer yearOfRelease, Genre genre) {
        this.id = count.incrementAndGet();
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(Integer yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", genre=" + genre +
                ", avgRating=" + avgRating +
                '}';
    }
}
