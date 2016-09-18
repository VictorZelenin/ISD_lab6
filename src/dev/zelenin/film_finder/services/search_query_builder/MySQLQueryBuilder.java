package dev.zelenin.film_finder.services.search_query_builder;

import dev.zelenin.film_finder.data.MovieType;

/**
 * Created by victor on 18.09.16.
 */
public class MySQLQueryBuilder extends QueryBuilder {
    @Override
    public void createQuery() {
        queryBuilder = new StringBuilder("select * from movies where ");
    }

    @Override
    public void addTitlePart(String title, boolean isLast) {
        queryBuilder.append("title = '")
                .append(title)
                .append("'");
        addLast(isLast);
    }

    @Override
    public void addReleaseYearPart(String year, boolean isLast) {
        queryBuilder.append("release_date = '")
                .append(year)
                .append("'");
        addLast(isLast);
    }

    @Override
    public void addImdbRatingPart(double mark, boolean isLast) {
        queryBuilder.append("imdb_rating > '")
                .append(mark)
                .append("'");
        addLast(isLast);
    }

    @Override
    public void addMovieTypePart(String movieType, boolean isLast) {
        queryBuilder.append("movie_type = '")
                .append(MovieType.parseMovieType(movieType))
                .append("'");
        addLast(isLast);
    }

    @Override
    public void addRuntimePart(int runtime, boolean isLast) {
        queryBuilder.append("runtime >= '")
                .append(runtime)
                .append("'");
        addLast(isLast);
    }

    private void addLast(boolean isLast) {
        if (isLast)
            queryBuilder.append(";");
        else
            queryBuilder.append(" and ");
    }
}
