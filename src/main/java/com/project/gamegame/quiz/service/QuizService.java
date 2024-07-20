package com.project.gamegame.quiz.service;

import com.project.gamegame.quiz.domain.Quiz;
import com.project.gamegame.quiz.dto.quiz.QuizCreateRequest;
import com.project.gamegame.quiz.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;

    public void createQuiz(QuizCreateRequest request) {

        Quiz quiz = Quiz.builder()
                .quizType(request.getQuizType())
                .title(request.getTitle())
                .content(request.getContent())
                .answer(request.getAnswer())
                .build();

        quizRepository.save(quiz);
    }
}
