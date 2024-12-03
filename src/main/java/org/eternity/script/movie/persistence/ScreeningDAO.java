package org.eternity.script.movie.persistence;

import org.eternity.script.movie.domain.Screening;

public interface ScreeningDAO {
    Screening selectScreening(Long screeningId);

    void insert(Screening screening);
}
