package com.example.coursework3.service;

import com.example.coursework3.model.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JavaQuestionServiceTest {

    JavaQuestionService javaQuestionService;

    @Test
    @BeforeEach
    public void setup() {
        javaQuestionService = new JavaQuestionService();

        Question question1 = new Question("Вопрос 1", "Ответ 1");
        Question question2 = new Question("Вопрос 2", "Ответ 2");
        Question question3 = new Question("Вопрос 3", "Ответ 3");

        javaQuestionService.add("Вопрос 1", "Ответ 1");
        javaQuestionService.add("Вопрос 2", "Ответ 2");
        javaQuestionService.add("Вопрос 3", "Ответ 3");

        Assertions.assertThat(javaQuestionService.getList().size()).isEqualTo(3);
        Assertions.assertThat(javaQuestionService.getList().get(0)).isEqualTo(question1);
        Assertions.assertThat(javaQuestionService.getList().get(1)).isEqualTo(question2);
        Assertions.assertThat(javaQuestionService.getList().get(2)).isEqualTo(question3);
    }

    @Test
    public void remove() {
        javaQuestionService.remove(new Question("Вопрос 2", "Ответ 2"));
        Assertions.assertThat(javaQuestionService.getList().size()).isEqualTo(2);
        Assertions.assertThat(javaQuestionService.getList().get(0)).isEqualTo(new Question("Вопрос 1", "Ответ 1"));
        Assertions.assertThat(javaQuestionService.getList().get(1)).isEqualTo(new Question("Вопрос 3", "Ответ 3"));
    }

    @Test
    public void getAllQuestions() {
        Question question1 = new Question("Вопрос 1", "Ответ 1");
        Question question2 = new Question("Вопрос 2", "Ответ 2");
        Question question3 = new Question("Вопрос 3", "Ответ 3");
        List<Question> list = new ArrayList<>();
        list.add(question1);
        list.add(question2);
        list.add(question3);

        Assertions.assertThat(javaQuestionService.getList()).isEqualTo(list);
    }

    @Test
    public void getRandomQuestion() {
        Question question1 = new Question("Вопрос 1", "Ответ 1");
        Question question2 = new Question("Вопрос 2", "Ответ 2");
        Question question3 = new Question("Вопрос 3", "Ответ 3");
        List<Question> list = new ArrayList<>();
        list.add(question1);
        list.add(question2);
        list.add(question3);

        Assertions.assertThat(list).contains(javaQuestionService.getRandomQuestion());
    }
}
