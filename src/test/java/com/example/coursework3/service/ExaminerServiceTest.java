package com.example.coursework3.service;

import com.example.coursework3.exception.IllegalQuestionsAmount;
import com.example.coursework3.model.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {
    public Question question = new Question("Вопрос 1", "Ответ 1");

    @Mock
    JavaQuestionService javaQuestionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    @Test
    void getQuestions() {
        Mockito.when(javaQuestionService.getCount()).thenReturn(1);
        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(question);
        List<Question> list = new ArrayList<>();
        list.add(question);
        Assertions.assertThat(examinerService.getQuestions(1)).isEqualTo(list);
    }

    @Test
    void throwException() {
        Mockito.when(javaQuestionService.getCount()).thenReturn(0);
        org.junit.jupiter.api.Assertions.assertThrows(IllegalQuestionsAmount.class,
                () -> examinerService.getQuestions(1));
    }
}
