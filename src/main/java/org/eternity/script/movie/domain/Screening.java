package org.eternity.script.movie.domain;

import lombok.*;
import org.eternity.script.generic.PlayTime;

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

    public boolean isPlayedIn(PlayTime playTime) {
        return this.screeningTime.getDayOfWeek().equals(playTime.getDayOfWeek()) &&
                playTime.getInterval().includes(this.screeningTime.toLocalTime());
    }
}
