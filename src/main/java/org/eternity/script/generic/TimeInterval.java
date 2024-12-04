package org.eternity.script.generic;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor
@Getter
public class TimeInterval {
    private LocalTime startTime;
    private LocalTime endTime;

    public boolean includes(LocalTime localTime) {
        return localTime.equals(startTime) || localTime.isAfter(startTime) &&
            localTime.equals(endTime) || localTime.isBefore(endTime);
    }
}
