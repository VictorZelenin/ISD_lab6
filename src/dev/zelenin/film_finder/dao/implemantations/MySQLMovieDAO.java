package dev.zelenin.film_finder.dao.implemantations;

import dev.zelenin.film_finder.dao.interfaces.MovieDAO;
import dev.zelenin.film_finder.data.Movie;
import dev.zelenin.film_finder.data.MovieType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by victor on 18.09.16.
 */
public class MySQLMovieDAO implements MovieDAO {
    private Connection connection;

    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db" +
                    "?useUnicode=true&characterEncoding=UTF8", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
        List<Movie> movies = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {

            statement.executeQuery(query);
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                movies.add(
                        new Movie(
                                resultSet.getString(2),
                                MovieType.parseMovieType(resultSet.getString(3)),
                                parseUtilDateFromSQLDate(resultSet, 4),
                                resultSet.getInt(5),
                                resultSet.getDouble(6)
                        ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movies;
    }

    private static java.util.Date parseUtilDateFromSQLDate(ResultSet resultSet, int index) {
        java.sql.Date date;
        try {
            date = resultSet.getDate(index);
        } catch (SQLException e) {
            // logging
            return null;
        }
        // logging
        if (date == null) {
            return null;
        } else {
            return new java.util.Date(date.getTime());
        }
    }

}
