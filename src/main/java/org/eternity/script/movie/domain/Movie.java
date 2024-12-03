package org.eternity.script.movie.domain;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor
@Getter @Setter
public class Movie {
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
