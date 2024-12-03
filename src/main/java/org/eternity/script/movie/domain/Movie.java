package org.eternity.script.movie.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor
@Getter @Setter
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long policyId;
	private String title;
	private Integer runningTime;
	private Long fee;

	public Movie(Long policyId, String title, Integer runningTime, Long fee) {
		this.policyId = policyId;
		this.title = title;
		this.runningTime = runningTime;
		this.fee = fee;
	}
}
