package com.highthon.school.domain.board.exception;

import com.highthon.school.global.error.BasicException;
import com.highthon.school.global.error.ExceptionMessage;

public class BoardNotFoundException extends BasicException {
	public BoardNotFoundException() {
		super(ExceptionMessage.BOARD_NOT_FOUND);
	}
}
