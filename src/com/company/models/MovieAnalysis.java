package com.company.models;

import com.company.utils.enums.UserType;

import java.util.concurrent.atomic.AtomicInteger;

public class MovieAnalysis {
    private static final AtomicInteger count = new AtomicInteger(0);

    private Integer id;

    private Integer movieId;

    private UserType userType;

    private Integer rating;

    public MovieAnalysis() {
        this.id = count.incrementAndGet();
    }

    public MovieAnalysis(Integer movieId, UserType userType, Integer rating) {
        this.id = count.incrementAndGet();
        this.movieId = movieId;
        this.userType = userType;
        this.rating = rating;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "MovieAnalysis{" +
                "Id=" + id +
                ", movieId=" + movieId +
                ", userType=" + userType +
                ", rating=" + rating +
                '}';
    }
}
