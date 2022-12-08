package com.example.coursework3.service;

import com.example.coursework3.exception.IllegalQuestionsAmount;
import com.example.coursework3.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (javaQuestionService.getCount() < amount) {
            throw new IllegalQuestionsAmount();
        }
        Set<Question> questions = new HashSet<>(amount);

        while (questions.size() < amount) {
            Question q = javaQuestionService.getRandomQuestion();
            if (!questions.contains(q)) {
                questions.add(q);
            }
        }
        return questions;
    }
}
