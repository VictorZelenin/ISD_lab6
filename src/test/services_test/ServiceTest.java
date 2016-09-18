package services_test;

import dev.zelenin.film_finder.data.Movie;
import dev.zelenin.film_finder.services.SearchService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by victor on 18.09.16.
 */
public class ServiceTest {
    private SearchService searchService;

    @Before
    public void init() {
        searchService = new SearchService();
    }

    @Test(expected = RuntimeException.class)
    public void testGetMoviesByEmptyParamMap() {
        Map<String, String> paramMap = new HashMap<>();

        System.out.println(searchService.getMoviesBySearchParams(paramMap));
    }

    @Test
    public void testGetMoviesByTitleOnly() {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("title", "Breaking Bad");

        List<Movie> movies = searchService.getMoviesBySearchParams(paramMap);

        Assert.assertTrue(movies.get(0).getTitle().equals("Breaking Bad"));
    }

    @Test
    public void testGetMoviesByParameters() {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("movie_type", "series");
        paramMap.put("imdb_rating", "8.5");

        List<Movie> movies = searchService.getMoviesBySearchParams(paramMap);

        Assert.assertTrue(movies.get(0).getTitle().equals("Breaking Bad"));
    }
}
