package com.example.coursework3.controller;

import com.example.coursework3.exception.IllegalQuestionsAmount;
import com.example.coursework3.model.Question;
import com.example.coursework3.service.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {
    ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/exam/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable(value = "amount") int amount) {
            return examinerService.getQuestions(amount);
        }
    }
