package com.project.gamegame.quiz.controller;

import com.project.gamegame.common.response.ApiSuccessResponse;
import com.project.gamegame.quiz.dto.quiz.QuizCreateRequest;
import com.project.gamegame.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/quizs")
public class QuizController {

    private final QuizService quizService;

    @PostMapping("/create")
    public ApiSuccessResponse<?> createQuiz(@RequestBody QuizCreateRequest request) {
        quizService.createQuiz(request);
        return ApiSuccessResponse.NO_DATA_RESPONSE;
    }
}
