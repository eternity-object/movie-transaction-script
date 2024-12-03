package org.eternity.script.movie.persistence.jpa;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.eternity.script.movie.domain.Movie;
import org.eternity.script.movie.persistence.MovieDAO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
@Transactional
public class MovieJpaDAO implements MovieDAO {
    private EntityManager em;

    public MovieJpaDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public Movie selectMovie(Long movieId) {
        return em.find(Movie.class, movieId);
    }

    @Override
    public void insert(Movie movie) {
        em.persist(movie);
    }
}
