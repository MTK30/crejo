package com.company.services;

import com.company.models.Movie;
import com.company.models.MovieAnalysis;
import com.company.utils.Const;
import com.company.utils.enums.Genre;
import com.company.utils.enums.UserType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortingService {

    public static Map<String,String> getHighestRatedMovieBYYear(Integer year){
        List<Integer> movieIds = Const.movies.stream()
                .filter(movie -> movie.getYearOfRelease().equals(year))
                .map(Movie::getId)
                .collect(Collectors.toList());
        Integer max = Integer.MIN_VALUE;
        Integer mid = 0;
        for(Integer id : movieIds) {
            MovieAnalysis ma = Const.movieAnalyses.stream()
                    .filter(movieAnalysis -> movieAnalysis.getMovieId().equals(id))
                    .findFirst().orElse(null);
            if (ma !=null && ma.getRating() > max) {
                mid = ma.getMovieId();
                max = ma.getRating();
            }
        }

        Map<String,String> movieRatingMapping = new HashMap<>();
        if (max  == Integer.MIN_VALUE || mid == null ) {
            System.out.println("Error : movieAnalyses ");
            return null;
        }
        final Integer moviId = mid;
//        System.out.println("mo"+max+" "+mid);
        Movie m = Const.movies.stream().filter(movie -> movie.getId().equals(moviId)).findFirst().orElse(null);
        movieRatingMapping.put("MovieName",m.getName());
        movieRatingMapping.put("MovieRating", String.valueOf(max));
        return movieRatingMapping;
    }


    public static Map<String,String> getHighestRatedMovieByYearCriticsPrefered(Integer year){
        List<Integer> movieIds = Const.movies.stream()
                .filter(movie -> movie.getYearOfRelease().equals(year))
                .map(Movie::getId)
                .collect(Collectors.toList());

        Integer max = Integer.MIN_VALUE;
        Integer mid = 0;
        for(Integer id : movieIds) {
            MovieAnalysis ma = Const.movieAnalyses.stream()
                    .filter(movieAnalysis -> movieAnalysis.getMovieId().equals(id))
                    .filter(movieAnalysis -> movieAnalysis.getUserType().equals(UserType.Critic))
                    .findFirst().orElse(null);
            if (ma !=null && ma.getRating() > max) {
                mid = ma.getMovieId();
                max = ma.getRating();
            }
        }

        Map<String,String> movieRatingMapping = new HashMap<>();
        if (max  == Integer.MIN_VALUE || mid == null ) {
            System.out.println("Error : movieAnalyses ");
            return null;
        }
        final Integer moviId = mid;
//        System.out.println("mo"+max+" "+mid);
        Movie m = Const.movies.stream().filter(movie -> movie.getId().equals(moviId)).findFirst().orElse(null);
        movieRatingMapping.put("MovieName",m.getName());
        movieRatingMapping.put("MovieRating", String.valueOf(max));
        return movieRatingMapping;
    }

    public static Map<String,String> getReviewByGenre(Genre genre) {
        List<Integer> movieIds = Const.movies.stream()
                .filter(movie -> movie.getGenre().equals(genre))
                .map(Movie::getId)
                .collect(Collectors.toList());
        Integer max = Integer.MIN_VALUE;
        Integer mid = 0;
        for(Integer id : movieIds) {
            MovieAnalysis ma = Const.movieAnalyses.stream()
                    .filter(movieAnalysis -> movieAnalysis.getMovieId().equals(id))
                    .findFirst().orElse(null);
            if (ma !=null && ma.getRating() > max) {
                mid = ma.getMovieId();
                max = ma.getRating();
            }
        }

        Map<String,String> movieRatingMapping = new HashMap<>();
        if (max  == Integer.MIN_VALUE || mid == null ) {
            System.out.println("Error : movieAnalyses ");
            return null;
        }
        final Integer moviId = mid;
//        System.out.println("mo"+max+" "+mid);
        Movie m = Const.movies.stream().filter(movie -> movie.getId().equals(moviId)).findFirst().orElse(null);
        movieRatingMapping.put("MovieName",m.getName());
        movieRatingMapping.put("MovieRating", String.valueOf(max));
        return movieRatingMapping;
    }

    public static Integer getTotalReviewScore(Integer year){
        List<Integer> movieIds = Const.movies.stream()
                .filter(movie -> movie.getYearOfRelease().equals(year))
                .map(Movie::getId)
                .collect(Collectors.toList());
        Integer max = Integer.MIN_VALUE;
        Integer totalRating = 0;
        for(Integer id : movieIds) {
            MovieAnalysis ma = Const.movieAnalyses.stream()
                    .filter(movieAnalysis -> movieAnalysis.getMovieId().equals(id))
                    .findFirst().orElse(null);
            if (ma !=null ) {
                totalRating += ma.getRating();
            }
        }
        return totalRating;
    }


}
