package org.example;

import java.util.*;

public class Movie {
    private String title;
    private String genre;
    private double rating;
    private int year;
    private String studio;

    public Movie(String title, String genre, double rating, int year, String studio) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.year = year;
        this.studio = studio;
    }

    public static List<Movie> filterMovies(List<Movie> movies, MoviePredicate predicate) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie: movies) {
            if (predicate.test(movie)) {
                result.add(movie);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", year=" + year +
                ", studio='" + studio + '\'' +  // выводим студию
                '}';
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStudio() {
        return studio;  // геттер для студии
    }

    public void setStudio(String studio) {
        this.studio = studio;  // сеттер для студии
    }
}
