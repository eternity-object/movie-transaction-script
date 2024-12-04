package org.eternity.script.movie.service;

import org.eternity.script.movie.domain.*;
import org.eternity.script.movie.persistence.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static java.time.DayOfWeek.MONDAY;
import static org.eternity.script.movie.domain.DiscountCondition.ConditionType.PERIOD_CONDITION;
import static org.eternity.script.movie.domain.DiscountCondition.ConditionType.SEQUENCE_CONDITION;
import static org.eternity.script.movie.domain.DiscountPolicy.PolicyType.AMOUNT_POLICY;

@ExtendWith(MockitoExtension.class)
public class ReservationServiceTest {
    @InjectMocks  private ReservationService reservationService;

    @Mock private ScreeningDAO screeningDAO;
    @Mock private MovieDAO movieDAO;
    @Mock private DiscountPolicyDAO discountPolicyDAO;
    @Mock private DiscountConditionDAO discountConditionDAO;
    @Mock private ReservationDAO reservationDAO;

    @Test
    public void 금액할인정책_계산() {
        // given
        Long customerId = 1L;
        Long screeningId = 1L;
        Long movieId = 1L;
        Long policyId = 1L;

        Mockito.when(screeningDAO.selectScreening(screeningId))
                .thenReturn(new Screening(screeningId, movieId, 1, LocalDateTime.of(2024, 12, 11, 18, 0)));

        Mockito.when(movieDAO.selectMovie(movieId))
                .thenReturn(new Movie(movieId, policyId, "한신", 120, 10000L));

        Mockito.when(discountPolicyDAO.selectDiscountPolicy(movieId))
                .thenReturn(new DiscountPolicy(policyId, movieId, AMOUNT_POLICY, 1000L, null));

        Mockito.when(discountConditionDAO.selectDiscountConditions(policyId))
                .thenReturn(List.of(
                        new DiscountCondition(1L, policyId, SEQUENCE_CONDITION, null, null, null, 1),
                        new DiscountCondition(3L, policyId, PERIOD_CONDITION, MONDAY, LocalTime.of(9, 0), LocalTime.of(11, 30), null)));

        // when
        Reservation reservation = reservationService.reserveScreening(customerId, screeningId, 2);

        // then
        Assertions.assertEquals(reservation.getFee(), 18000L);
    }
}
