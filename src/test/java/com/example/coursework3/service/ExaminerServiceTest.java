package com.example.coursework3.service;

import com.example.coursework3.exception.IllegalQuestionsAmount;
import com.example.coursework3.model.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

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
        Set<Question> list = new HashSet<>();
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
