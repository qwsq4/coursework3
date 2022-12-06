package com.example.coursework3.service;

import com.example.coursework3.exception.IllegalQuestionsAmount;
import com.example.coursework3.model.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (javaQuestionService.getCount() < amount) {
            throw new IllegalQuestionsAmount();
        }
        List<Question> questions = new ArrayList<>(amount);

        while (questions.size() < amount) {
            Question q = javaQuestionService.getRandomQuestion();
            if (!questions.contains(q)) {
                questions.add(q);
            }
        }
        return questions;
    }
}
