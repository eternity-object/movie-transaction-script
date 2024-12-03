package org.eternity.script.movie.persistence.jpa;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.eternity.script.movie.domain.DiscountCondition;
import org.eternity.script.movie.persistence.DiscountConditionDAO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
@Transactional
public class DiscountConditionJpaDAO implements DiscountConditionDAO {
    private EntityManager em;

    public DiscountConditionJpaDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<DiscountCondition> selectDiscountConditions(Long policyId) {
        return em.createQuery("select c from DiscountCondition c where c.policyId = :policyId", DiscountCondition.class)
                .setParameter("policyId", policyId)
                .getResultList();
    }

    @Override
    public void insert(DiscountCondition discountCondition) {
        em.persist(discountCondition);
    }
}
