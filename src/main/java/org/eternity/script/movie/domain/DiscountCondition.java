package org.eternity.script.movie.domain;

import jakarta.persistence.*;
import lombok.*;
import org.eternity.script.generic.PlayTime;

@Entity
@SequenceGenerator(
        name = "discount_seq",
        sequenceName = "discount_seq",
        initialValue = 1, allocationSize = 50
)
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor
@Getter @Setter
public class DiscountCondition {
    public enum ConditionType { PERIOD_CONDITION, SEQUENCE_CONDITION }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discount_sequence")
    private Long id;
    private Long policyId;
    private ConditionType conditionType;
    private PlayTime playTime;
    private Integer sequence;

    public DiscountCondition(Long policyId, ConditionType conditionType, PlayTime playTime, Integer sequence) {
        this.policyId = policyId;
        this.conditionType = conditionType;
        this.playTime = playTime;
        this.sequence = sequence;
    }
    public boolean isPeriodCondition() {
        return ConditionType.PERIOD_CONDITION.equals(conditionType);
    }

    public boolean isSequenceCondition() {
        return ConditionType.SEQUENCE_CONDITION.equals(conditionType);
    }
}
