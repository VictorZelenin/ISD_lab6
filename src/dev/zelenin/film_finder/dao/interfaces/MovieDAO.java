package dev.zelenin.film_finder.dao.interfaces;

import dev.zelenin.film_finder.data.Movie;

import java.util.List;

/**
 * Created by victor on 18.09.16.
 */
public interface MovieDAO {

    Movie findByTitle(String title);

    int addMovie(Movie movie);

    int updateMovie(int id, Movie movie);

    int removeMovie(Movie movie);

    List<Movie> findBySearchQuery(String query);
}
