package org.eternity.script.movie.persistence.memory;

import org.eternity.script.movie.domain.DiscountCondition;
import org.eternity.script.movie.persistence.DiscountConditionDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DiscountConditionMemoryDAO extends InMemoryDAO<DiscountCondition> implements DiscountConditionDAO {
    @Override
    public List<DiscountCondition> selectDiscountConditions(Long policyId) {
        return findMany(condition -> condition.getPolicyId().equals(policyId));
    }
}
