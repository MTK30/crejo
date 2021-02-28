package com.company.services;

import com.company.models.MovieAnalysis;
import com.company.utils.Const;
import com.company.utils.enums.UserType;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class MovieAnalysisService {

    public static MovieAnalysis updateMovieAnalysis(Integer movieId,Integer userId,Integer rating) {
        List<MovieAnalysis> movieAnalysis = null;
        MovieAnalysis movieAnalys1 = null;
        Long count = ReviewService.countNoOfRating(userId);
        UserType userType = getUserType(count);
        movieAnalysis = Const.movieAnalyses.stream()
                .filter(movieAnalysis1 -> movieAnalysis1.getMovieId() == movieId
                        && movieAnalysis1.getUserType() == userType)
                .collect(Collectors.toList());
        if (movieAnalysis.size() == 0) {
            movieAnalys1 = new MovieAnalysis(movieId,userType,rating);
            Const.movieAnalyses.add(movieAnalys1);
        } else {
            movieAnalys1 = movieAnalysis.get(0);
            if (userType.equals(UserType.User)) {
                movieAnalys1.setRating(movieAnalys1.getRating() + (rating*1));
            } else if (userType.equals(UserType.Critic)){
                movieAnalys1.setRating(movieAnalys1.getRating() + (rating*2));
            } else if (userType.equals(UserType.Expert)) {
                movieAnalys1.setRating(movieAnalys1.getRating() + (rating*3));
            } else if (userType.equals(UserType.Admin)) {
                movieAnalys1.setRating(movieAnalys1.getRating() + (rating*4));
            }
        }
        return movieAnalys1;
    }

    public static UserType getUserType(Long count) {
        UserType userType = null;
        if (count < 3){
            userType = UserType.User;
        } else if (count >=3 && count <6 ) {
            userType = UserType.Critic;
        }else if (count >=6 && count < 9) {
            userType = UserType.Expert;
        }else if (count >=9 ) {
            userType = UserType.Admin;
        }
        return userType;
    }

    public static void printMovieAnalysis() {
        for (MovieAnalysis movieAnalysis : Const.movieAnalyses) {
            System.out.println(movieAnalysis);
        }
    }
}
