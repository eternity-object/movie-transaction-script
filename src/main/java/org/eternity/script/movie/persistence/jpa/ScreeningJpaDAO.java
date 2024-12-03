package org.eternity.script.movie.persistence.jpa;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.eternity.script.movie.domain.Screening;
import org.eternity.script.movie.persistence.ScreeningDAO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
@Transactional
public class ScreeningJpaDAO implements ScreeningDAO {
    private EntityManager em;

    public ScreeningJpaDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public Screening selectScreening(Long screeningId) {
        return em.find(Screening.class, screeningId);
    }

    @Override
    public void insert(Screening screening) {
        em.persist(screening);
    }
}
