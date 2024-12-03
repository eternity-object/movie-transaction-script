package org.eternity.script.movie.persistence;

import org.eternity.script.movie.domain.Reservation;

public interface ReservationDAO {
    void insert(Reservation reservation);
}
