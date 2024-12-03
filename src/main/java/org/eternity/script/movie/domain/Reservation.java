package org.eternity.script.movie.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;
import lombok.*;

@Entity
@TableGenerator(
        name = "seq_table",
        table = "seq_table",
        pkColumnName = "seq_name", pkColumnValue = "reservation_seq",
        initialValue = 1, allocationSize = 20
)
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor
@Getter @Setter
public class Reservation {
    @Id
    @GeneratedValue(generator = "seq_table")
    private Long id;
    private Long customerId;
    private Long screeningId;
    private Integer audienceCount;
    private Long fee;

    public Reservation(Long customerId, Long screeningId, Integer audienceCount, Long fee) {
        this.customerId = customerId;
        this.screeningId = screeningId;
        this.audienceCount = audienceCount;
        this.fee = fee;
    }
}
