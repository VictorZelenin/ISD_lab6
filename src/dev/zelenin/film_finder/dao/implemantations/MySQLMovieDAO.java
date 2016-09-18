package dev.zelenin.film_finder.dao.implemantations;

import dev.zelenin.film_finder.dao.interfaces.MovieDAO;
import dev.zelenin.film_finder.data.Movie;

import java.util.List;

/**
 * Created by victor on 18.09.16.
 */
public class MySQLMovieDAO implements MovieDAO {
    @Override
    public Movie findByTitle(String title) {
        return null;
    }

    @Override
    public int addMovie(Movie movie) {
        return 0;
    }

    @Override
    public int updateMovie(int id, Movie movie) {
        return 0;
    }

    @Override
    public int removeMovie(Movie movie) {
        return 0;
    }

    @Override
    public List<Movie> findBySearchQuery(String query) {


        return null;
    }
}
