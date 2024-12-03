package org.eternity.script.movie.domain;

import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor
@Getter @Setter
public class Screening {
    private Long id;
    private Long movieId;
    private Integer sequence;
    private LocalDateTime screeningTime;

    public Screening(Long movieId, Integer sequence, LocalDateTime screeningTime) {
        this.movieId = movieId;
        this.sequence = sequence;
        this.screeningTime = screeningTime;
    }

    public boolean isPlayedIn(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        return this.screeningTime.getDayOfWeek().equals(dayOfWeek) &&
                (this.screeningTime.toLocalTime().equals(startTime) || this.screeningTime.toLocalTime().isAfter(startTime)) &&
                (this.screeningTime.toLocalTime().equals(endTime) || this.screeningTime.toLocalTime().isBefore(endTime));
    }
}
