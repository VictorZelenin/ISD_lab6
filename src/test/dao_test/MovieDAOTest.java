package dao_test;

import dev.zelenin.film_finder.dao.implemantations.MySQLMovieDAO;
import dev.zelenin.film_finder.dao.interfaces.MovieDAO;
import dev.zelenin.film_finder.data.Movie;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by victor on 18.09.16.
 */
public class MovieDAOTest {

    @Test
    public void testFindByQuery() {
        MovieDAO dao = new MySQLMovieDAO();
        List<Movie> movies = dao.findBySearchQuery("select * from movies");
        System.out.println(movies);

        Assert.assertTrue(movies.size() > 0);
    }
}
