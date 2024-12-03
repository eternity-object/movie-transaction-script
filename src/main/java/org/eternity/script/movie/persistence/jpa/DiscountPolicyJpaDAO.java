package org.eternity.script.movie.persistence.jpa;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.eternity.script.movie.domain.DiscountPolicy;
import org.eternity.script.movie.persistence.DiscountPolicyDAO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
@Transactional
public class DiscountPolicyJpaDAO implements DiscountPolicyDAO {
    private EntityManager em;

    public DiscountPolicyJpaDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public DiscountPolicy selectDiscountPolicy(Long movieId) {
        return em.createQuery("select p from DiscountPolicy p where p.movieId = :movieId", DiscountPolicy.class)
                .setParameter("movieId", movieId)
                .getSingleResult();
    }

    @Override
    public void insert(DiscountPolicy discountPolicy) {
        em.persist(discountPolicy);
    }
}
