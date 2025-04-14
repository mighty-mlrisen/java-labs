package org.example;

public class MovieStudioPredicate implements MoviePredicate {

    @Override
    public boolean test(Movie movie) {
        return movie.getStudio().equalsIgnoreCase("Paramount");
    }
}
