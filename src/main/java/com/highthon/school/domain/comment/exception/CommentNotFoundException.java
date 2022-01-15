package com.highthon.school.domain.comment.exception;

import com.highthon.school.global.error.BasicException;
import com.highthon.school.global.error.ExceptionMessage;

public class CommentNotFoundException extends BasicException {
	public CommentNotFoundException() {super(ExceptionMessage.COMMENT_NOT_FOUND);}
}
