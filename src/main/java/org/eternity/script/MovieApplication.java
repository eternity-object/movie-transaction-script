package org.eternity.script;

import lombok.extern.slf4j.Slf4j;
import org.eternity.script.movie.domain.Reservation;
import org.eternity.script.movie.service.ReservationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@Slf4j
@SpringBootApplication
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = {".*persistence\\.jpa\\..*"}))
public class MovieApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MovieApplication.class, args);
		ReservationService reservationService = context.getBean(ReservationService.class);

		Reservation reservation = reservationService.reserveScreening(1L, 1L, 2);
		log.info("관객수 : {}명, 요금: {}원", reservation.getAudienceCount(), reservation.getFee());
	}
}
