package org.example;

public class MovieGenrePredicate implements MoviePredicate {

    @Override
    public boolean test(Movie movie) {
        return movie.getGenre().equalsIgnoreCase("Приключения");
    }

}
