package org.eternity.script.movie.persistence;

import org.eternity.script.movie.domain.DiscountCondition;

import java.util.List;

public interface DiscountConditionDAO {
    List<DiscountCondition> selectDiscountConditions(Long policyId);

    void insert(DiscountCondition discountCondition);
}
