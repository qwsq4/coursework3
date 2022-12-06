package com.example.coursework3.controller;

import com.example.coursework3.model.Question;
import com.example.coursework3.service.JavaQuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping
    public Collection<Question> getAll(){
        return this.javaQuestionService.getAll();
    }

    @PostMapping("/add/question={questionText},answer={answerText}")
    public Question add(@PathVariable(value = "questionText") String question,
                        @PathVariable(value = "answerText") String answer) {
        return this.javaQuestionService.add(question, answer);
    }

    @PostMapping("/remove/question={questionText},answer={answerText}")
    public Question remove(@PathVariable(value = "questionText") String question,
                           @PathVariable(value = "answerText") String answer) {
        return this.javaQuestionService.remove(new Question(question, answer));
    }
}
