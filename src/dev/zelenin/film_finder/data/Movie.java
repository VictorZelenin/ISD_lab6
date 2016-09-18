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
    private final String plot;
    private final String country;

    private final double imdbRating;

    public Movie(String title, MovieType movieType,
                 Date releaseDate, int runtime, String plot, String country, double imdbRating) {
        this.title = title;
        this.movieType = movieType;
        this.releaseDate = releaseDate;
        this.runtime = runtime;
        this.plot = plot;
        this.country = country;
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

    public String getPlot() {
        return plot;
    }

    public String getCountry() {
        return country;
    }

    public double getImdbRating() {
        return imdbRating;
    }
}
