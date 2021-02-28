package com.company.services;

import com.company.models.Movie;
import com.company.utils.Const;
import com.company.utils.enums.Genre;

import java.util.Date;

public class MovieService {

    public static Movie addMovie(String name,Integer yrOfRelease,String genre) {
        Movie movie  = new Movie();
        movie.setName(name.toLowerCase());
        movie.setYearOfRelease(yrOfRelease);
        Genre genre1 = Genre.fromString(genre.toLowerCase());
        movie.setGenre(genre1);
        Const.movies.add(movie);
        return movie;
    }

    public static void printMovie() {
        for (Movie movie : Const.movies) {
            System.out.println(movie);
        }
    }

    public static Movie getMovieByName(String name) {
        for (Movie movie : Const.movies) {
//            System.out.println("Movie Name : "+movie.getName()+"SerachKey "+name.toLowerCase());
            if (movie.getName().equals(name.toLowerCase())) {
                return movie;
            }
        }
        return null;
    }
}
