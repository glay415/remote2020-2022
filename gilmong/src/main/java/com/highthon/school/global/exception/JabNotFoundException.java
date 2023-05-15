package com.highthon.school.global.exception;

import com.highthon.school.global.error.BasicException;
import com.highthon.school.global.error.ExceptionMessage;

public class JabNotFoundException extends BasicException {
    public JabNotFoundException() {
        super(ExceptionMessage.JOB_NOT_FOUND);
    }
}
