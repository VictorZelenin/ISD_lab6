package dev.zelenin.film_finder.data;

import java.util.Date;

/**
 * Created by victor on 18.09.16.
 */
public final class Movie {
    private final String title;
    private final MovieType movieType;

    private final Date releaseDate;
    private final int runtime;

    private final double imdbRating;

    public Movie(String title, MovieType movieType,
                 Date releaseDate, int runtime, double imdbRating) {
        this.title = title;
        this.movieType = movieType;
        this.releaseDate = releaseDate;
        this.runtime = runtime;
        this.imdbRating = imdbRating;
    }

    public String getTitle() {
        return title;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public int getRuntime() {
        return runtime;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", movieType=" + movieType +
                ", releaseDate=" + releaseDate +
                ", runtime=" + runtime +
                ", imdbRating=" + imdbRating +
                '}';
    }
}
