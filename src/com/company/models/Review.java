package com.company.models;

import com.company.utils.enums.UserType;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Review {
    private static final AtomicInteger count = new AtomicInteger(0);

    private Integer id;

    private Integer userId; // id of the User data

    private Integer movieId; //id of the movie data
    //movie_id and user_id will be kept as a PK, if created as a db model.

    private UserType userType;

    private Integer rating;

    public Review() {
        this.id = count.incrementAndGet();
    }

    public Review(Integer userId, Integer movieId, Integer rating) {
        this.id = count.incrementAndGet();
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", userId=" + userId +
                ", movieId=" + movieId +
                ", rating=" + rating +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(userId, review.userId) &&
                Objects.equals(movieId, review.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, movieId);
    }
}
