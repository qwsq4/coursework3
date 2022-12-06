package com.example.coursework3.service;

import com.example.coursework3.model.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {
    public Question question = new Question("Вопрос 1", "Ответ 1");

    @Mock
    JavaQuestionService javaQuestionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    @BeforeEach
    void setup() {
        List<Question> list = new ArrayList<>();
        list.add(new Question("", ""));
        Mockito.when(javaQuestionService.getCount()).thenReturn(1);
        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(question);
    }

    @Test
    void getQuestions() {
        List<Question> list = new ArrayList<>();
        list.add(question);
        Assertions.assertThat(this.examinerService.getQuestions(1)).isEqualTo(list);
    }
}
