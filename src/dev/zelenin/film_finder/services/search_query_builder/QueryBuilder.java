package dev.zelenin.film_finder.services.search_query_builder;

/**
 * Created by victor on 18.09.16.
 */
public abstract class QueryBuilder {
    protected StringBuilder queryBuilder;

    public String getSearchQuery() {
        return queryBuilder.toString();
    }

    public abstract void createQuery();

    public void addQueryPart(String partName, String value, boolean isLast) {
        switch (partName) {
            case "title":
                addTitlePart(value, isLast);
                break;
            case "release_date":
                addReleaseYearPart(value, isLast);
                break;
            case "imdb_rating":
                addImdbRatingPart(Double.parseDouble(value), isLast);
                break;
            case "movie_type":
                addMovieTypePart(value, isLast);
                break;
            case "runtime":
                addRuntimePart(Integer.parseInt(value), isLast);
                break;
        }
    }

    public abstract void addTitlePart(String title, boolean isLast);

    public abstract void addReleaseYearPart(String year, boolean isLast);

    public abstract void addImdbRatingPart(double mark, boolean isLast);

    public abstract void addMovieTypePart(String movieType, boolean isLast);

    public abstract void addRuntimePart(int runtime, boolean isLast);

}
