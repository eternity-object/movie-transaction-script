package org.eternity.script.movie.persistence;

import org.eternity.script.movie.domain.DiscountPolicy;

public interface DiscountPolicyDAO {
    DiscountPolicy selectDiscountPolicy(Long movieId);

    void insert(DiscountPolicy discountPolicy);
}
