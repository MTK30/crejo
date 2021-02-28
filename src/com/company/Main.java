package com.company;

import com.company.services.*;
import com.company.utils.enums.Genre;
import com.company.utils.enums.UserType;

import java.util.Map;

public class Main {



    public static void main(String[] args) {
	// write your code here
        System.out.println("=========Welcome============");
        UserService.addUser("MTK");
        UserService.addUser("SMK");
        UserService.printUsers();
        MovieService.addMovie("Don",2006,"Action");
        MovieService.addMovie("Metro",2006,"Romance");
        MovieService.addMovie("Guru",2008,"Drama");
        MovieService.addMovie("LunchBox",2021,"Drama");
        MovieService.printMovie();
        ReviewService.addReviews("mtk","Don",8);
        ReviewService.addReviews("tarun","Don",8);
        ReviewService.addReviews("smk","Don",1);
        ReviewService.addReviews("mtk","Don",8);
        ReviewService.addReviews("mtk","LunchBox",7);
        ReviewService.addReviews("mtk","Metro",7);
        ReviewService.addReviews("smk","Metro",10);
        ReviewService.addReviews("mtk","Guru",9);
        Map<String ,String> heighestRatedMovie = SortingService.getHighestRatedMovieBYYear(2006);
        System.out.println("Highest Rated movie of 2006 : "+heighestRatedMovie);
        Map<String ,String> heighestRatedMovieCreticsPrefered = SortingService.getHighestRatedMovieByYearCriticsPrefered(2008);
        System.out.println("Highest Rated movie of 2006 Critics Prefered : "+heighestRatedMovieCreticsPrefered);
        Map<String ,String> heighestRatedMovieByGenre = SortingService.getReviewByGenre(Genre.ACTION);
        System.out.println("Highest Rated of Genre Drama : "+heighestRatedMovieByGenre);
        Integer totalReviewByYear = SortingService.getTotalReviewScore(2006);
        System.out.println("Highest Rated of Genre Drama : "+totalReviewByYear);
    }
}
