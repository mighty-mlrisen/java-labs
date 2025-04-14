package org.example;

public class MovieYearPredicate implements MoviePredicate {

    @Override
    public boolean test(Movie movie) {
        return movie.getYear() >= 2000 && movie.getYear() <= 2020;
    }
}
