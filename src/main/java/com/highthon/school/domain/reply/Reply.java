package com.highthon.school.domain.reply;

import com.highthon.school.domain.comment.Comment;
import com.highthon.school.domain.user.User;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String content;

	@ManyToOne(fetch = FetchType.LAZY)
	private Comment comment;

	@ManyToOne
	private User user;

	@CreatedDate
	private LocalDateTime createAt;

	public Reply(String content, Comment comment, User user) {
		this.content = content;
		this.comment = comment;
		this.user = user;
	}
}
