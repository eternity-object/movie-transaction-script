package org.eternity.script.movie.persistence.jpa;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.eternity.script.movie.domain.Reservation;
import org.eternity.script.movie.persistence.ReservationDAO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
@Transactional
public class ReservationJpaDAO implements ReservationDAO {
    private EntityManager em;

    public ReservationJpaDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insert(Reservation reservation) {
        em.persist(reservation);
    }
}
