package com.example.coursework3.exception;

import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class IllegalQuestionsAmount extends ResponseStatusException {

    public IllegalQuestionsAmount() {
        super(BAD_REQUEST, "Кол-во запрашиваемых вопросов не соответствует кол-ву созданных в сервисе");
    }
}
