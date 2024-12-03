package org.eternity.script.movie.persistence.memory;

import org.eternity.script.movie.domain.Movie;
import org.eternity.script.movie.persistence.MovieDAO;
import org.springframework.stereotype.Repository;

@Repository
public class MovieMemoryDAO extends InMemoryDAO<Movie> implements MovieDAO {
    @Override
    public Movie selectMovie(Long movieId) {
        return findOne(movie -> movie.getId().equals(movieId));
    }
}
