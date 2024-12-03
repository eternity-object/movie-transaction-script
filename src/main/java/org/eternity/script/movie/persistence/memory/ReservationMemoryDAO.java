package org.eternity.script.movie.persistence.memory;

import org.eternity.script.movie.domain.Reservation;
import org.eternity.script.movie.persistence.ReservationDAO;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationMemoryDAO extends InMemoryDAO<Reservation> implements ReservationDAO {
    @Override
    public void insert(Reservation reservation) {
        super.insert(reservation);
    }
}
