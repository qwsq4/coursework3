package com.example.coursework3.model;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Objects;

public class Question {
    private final String question;
    private final String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this.hashCode() == o.hashCode()) return true;
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(question, question1.question) && Objects.equals(answer, question1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }

    @Override
    public String toString() {
        return "Вопрос - " + question + ", ответ - " + answer;
    }
}
