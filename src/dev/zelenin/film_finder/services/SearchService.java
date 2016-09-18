package dev.zelenin.film_finder.services;

import dev.zelenin.film_finder.dao.implemantations.MySQLMovieDAO;
import dev.zelenin.film_finder.dao.interfaces.MovieDAO;
import dev.zelenin.film_finder.data.Movie;
import dev.zelenin.film_finder.services.search_query_builder.MySQLQueryBuilder;
import dev.zelenin.film_finder.services.search_query_builder.QueryBuilder;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by victor on 18.09.16.
 */
public class SearchService {

    public List<Movie> getMoviesBySearchParams(Map<String, String> paramMap) {
        MovieDAO dao = new MySQLMovieDAO();

        checkParameterMap(paramMap);
        String query = constructSearchQuery(paramMap);

        return dao.findBySearchQuery(query);
    }

    private void checkParameterMap(Map<String, String> paramMap) {
        if (paramMap.isEmpty()) {
            throw new RuntimeException("Empty ParamMap");
        }
    }

    private String constructSearchQuery(Map<String, String> paramMap) {
        QueryBuilder builder = new MySQLQueryBuilder();
        builder.createQuery();

        int mapSize = paramMap.size();
        int i = 0;

        for (Entry<String, String> entry : paramMap.entrySet()) {
            if (i == mapSize - 1) {
                builder.addQueryPart(entry.getKey(), entry.getValue(), true);
            } else {
                builder.addQueryPart(entry.getKey(), entry.getValue(), false);
            }

            i++;
        }

        return builder.getSearchQuery();
    }
}
