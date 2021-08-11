package com.example.project.exception;

import org.springframework.http.HttpStatus;

public class ParticipantsAlreadyExceedException extends BusinessException {
    public ParticipantsAlreadyExceedException() {
        super("PARTICIPANTS_ALREADY_EXCEED", HttpStatus.PRECONDITION_FAILED);
    }
}
