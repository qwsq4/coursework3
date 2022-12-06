package com.example.coursework3.service;

import com.example.coursework3.model.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    List<Question> list;

    public JavaQuestionService() {
        this.list = new ArrayList<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question item = new Question(question, answer);
        list.add(item);
        return item;
    }

    @Override
    public Question add(Question question) {
        list.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        list.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return list;
    }

    @Override
    public Question getRandomQuestion() {
        return list.get(new Random().nextInt(0, list.size() - 1));
    }
}
