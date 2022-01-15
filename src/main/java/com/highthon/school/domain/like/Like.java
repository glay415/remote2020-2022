package com.highthon.school.domain.like;

import com.highthon.school.domain.board.Board;
import com.highthon.school.domain.user.User;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Like {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int num;

	@ManyToOne
	private Board board;

	@ManyToOne
	private User user;
}
