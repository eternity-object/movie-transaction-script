package org.eternity.script.movie.persistence;


import org.eternity.script.movie.domain.Movie;

public interface MovieDAO {
    Movie selectMovie(Long movieId);

    void insert(Movie movie);
}
