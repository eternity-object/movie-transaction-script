package org.eternity.script.movie.persistence.memory;

import org.eternity.script.movie.domain.DiscountPolicy;
import org.eternity.script.movie.persistence.DiscountPolicyDAO;
import org.springframework.stereotype.Repository;

@Repository
public class DiscountPolicyMemoryDAO extends InMemoryDAO<DiscountPolicy> implements DiscountPolicyDAO {
    @Override
    public DiscountPolicy selectDiscountPolicy(Long movieId) {
        return findOne(policy -> policy.getMovieId().equals(movieId));
    }
}
