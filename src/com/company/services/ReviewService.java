package com.company.services;

import com.company.models.Movie;
import com.company.models.Review;
import com.company.models.User;
import com.company.utils.Const;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewService {

    public static Review addReviews(String userName,String movieName,Integer rating){
        if (rating > 10 && rating < 0 ) {
            //TODO Raising Custom Exception Exception
            System.out.println("==================================Error : Please make sure the rating of the object is within the limits 0 and 10");
            return null;
        }
        Movie movie = MovieService.getMovieByName(movieName);
        if (movie == null ) {
            //TODO Raising Custom Exception
            System.out.println("==================================Error : Movie Doest exist with the name: "+movieName);
            return null;
        }
        Date d=new Date();
        int year=d.getYear() + 1900;
        if (movie.getYearOfRelease() >= year) {
            System.out.println("==================================Error : Movie Has not release : "+movieName);
            return null;
        }
        User user = UserService.getUserByName(userName);
        if (user == null ) {
            //TODO Raising Custom Exception
            System.out.println("==================================Error : User Doest exist with the name: "+userName);
            return null;
        }
        List<Review> reviews;
        reviews = Const.reviews.stream().
                filter(review -> review.getUserId() == user.getId()
                && review.getMovieId() == movie.getId())
                .collect(Collectors.toList());
        if (reviews.size() >= 1) {
            System.out.println("==================================Error : Multiple Rating : "+movieName+" "+userName +" "+rating);
            return null;
        }
        Long count = countNoOfRating(user.getId());
        MovieAnalysisService.updateMovieAnalysis(movie.id,user.getId(),rating);
        Review review = new Review();
        review.setMovieId(movie.id);
        review.setUserId(user.getId());
        review.setRating(rating);
        Const.reviews.add(review);


        return review;
    }


    public static void printReview() {
        for(Review review: Const.reviews) {
            System.out.println(review);
        }
    }


    public static Long countNoOfRating(Integer userId) {
        Long count = Const.reviews.stream().filter(review -> review.getUserId() == userId).count();
        return count;
    }
}
