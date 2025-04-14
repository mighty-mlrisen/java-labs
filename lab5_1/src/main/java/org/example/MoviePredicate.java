package org.example;

@FunctionalInterface
public interface MoviePredicate {
    boolean test(Movie movie);
}
