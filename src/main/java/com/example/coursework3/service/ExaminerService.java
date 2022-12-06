package com.example.coursework3.service;

import com.example.coursework3.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
