package org.eternity.script.movie.persistence.memory;

import org.eternity.script.movie.domain.Screening;
import org.eternity.script.movie.persistence.ScreeningDAO;
import org.springframework.stereotype.Repository;

@Repository
public class ScreeningMemoryDAO extends InMemoryDAO<Screening> implements ScreeningDAO {
    @Override
    public Screening selectScreening(Long id) {
        return findOne(screening -> screening.getId().equals(id));
    }
}
