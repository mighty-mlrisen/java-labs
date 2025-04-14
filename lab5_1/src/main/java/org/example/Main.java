package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Movie> movies = new ArrayList<>(List.of(
                new Movie("Выживание", "Драма", 7.8, 1995, "Warner Bros."),
                new Movie("Джон Уик", "Боевик", 8.3, 2014, "Lionsgate"),
                new Movie("Крестный отец", "Криминал", 9.2, 1972, "Paramount"),
                new Movie("Крестный отец 2", "Криминал", 9.0, 1974, "Paramount"),
                new Movie("Джон Уик 2", "Боевик", 8.4, 2017, "Lionsgate"),
                new Movie("Джон Уик 3", "Боевик", 8.5, 2019, "Lionsgate"),
                new Movie("Титаник", "Романтика", 7.8, 1997, "20th Century Fox"),
                new Movie("Интерстеллар", "Научная фантастика", 8.6, 2014, "Warner Bros."),
                new Movie("Мстители", "Фантастика", 8.0, 2012, "Marvel Studios"),
                new Movie("Шерлок Холмс", "Приключения", 7.6, 2009, "Warner Bros."),
                new Movie("Гарри Поттер и философский камень", "Фэнтези", 7.9, 2001, "Warner Bros."),
                new Movie("Парк Юрского периода", "Приключения", 8.1, 1993, "Universal Pictures")
        ));

        List<Movie> moviesAction = Movie.filterMovies(movies, new MovieGenrePredicate());
        System.out.println("\nФильмы жанра приключения:");
        Main.printMovies(moviesAction);

        List<Movie> moviesCrime = Movie.filterMovies(movies, movie -> movie.getGenre().equalsIgnoreCase("Криминал"));
        System.out.println("\nФильмы жанра криминал:");
        Main.printMovies(moviesCrime);

        List<Movie> moviesSciFi = Movie.filterMovies(movies, new MoviePredicate() {
            @Override
            public boolean test(Movie movie) {
                return movie.getGenre().equalsIgnoreCase("Драма");
            }
        });

        System.out.println("\nФильмы жанра драма:");
        Main.printMovies(moviesSciFi);

        List<Movie> sortedMovies = new ArrayList<>(movies);
        sortedMovies.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie movie1, Movie movie2) {
                return Double.compare(movie2.getRating(), movie1.getRating());
            }
        });

        System.out.println("\nФильмы, отсортированные по рейтингу:");
        Main.printMovies(sortedMovies);

        moviesAction.sort((Movie movie1, Movie movie2) -> Double.compare(movie2.getRating(), movie1.getRating()));

        System.out.println("\nФильмы жанра приключения, отсортированные по рейтингу:");
        Main.printMovies(moviesAction);

        List<Movie> filteredMoviesYear = Movie.filterMovies(movies, new MovieYearPredicate());
        System.out.println("\nФильмы от 2000 до 2020:");
        Main.printMovies(filteredMoviesYear);

        List<Movie> filteredMoviesYear2 = Movie.filterMovies(movies, movie -> movie.getYear() >= 1970 && movie.getYear() <= 2000);
        System.out.println("\nФильмы от 1970 до 2000:");
        Main.printMovies(filteredMoviesYear2);

        List<Movie> moviesParamount = Movie.filterMovies(movies, new MovieStudioPredicate());
        System.out.println("\nФильмы от студии Paramount:");
        Main.printMovies(moviesParamount);

        List<Movie> moviesLionsgate = Movie.filterMovies(movies, movie -> movie.getStudio().equalsIgnoreCase("Lionsgate"));
        System.out.println("\nФильмы от студии Lionsgate:");
        Main.printMovies(moviesLionsgate);

    }

    public static void printMovies(List<Movie> movies) {
        movies.forEach(movie -> System.out.println(movie.toString()));
    }
}