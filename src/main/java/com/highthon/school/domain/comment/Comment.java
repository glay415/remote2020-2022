package com.highthon.school.domain.comment;

import com.highthon.school.domain.board.Board;
import com.highthon.school.domain.reply.Reply;
import com.highthon.school.domain.user.User;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Comment {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false)
	private String content;

	@ManyToOne
	private Board board;

	@ManyToOne
	private User user;

	@CreatedDate
	private LocalDateTime createAt;

	@OneToMany(fetch = FetchType.EAGER,
		cascade = CascadeType.REMOVE)
	private List<Reply> replyList;

	public Comment(String content, Board board, User user) {
		this.content = content;
		this.board = board;
		this.user = user;
	}
}
