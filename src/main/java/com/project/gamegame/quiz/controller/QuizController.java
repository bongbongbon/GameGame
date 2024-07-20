package com.project.gamegame.quiz.controller;

import com.project.gamegame.common.response.ApiSuccessResponse;
import com.project.gamegame.quiz.dto.quiz.QuizCreateRequest;
import com.project.gamegame.quiz.dto.quiz.QuizResponse;
import com.project.gamegame.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/quizzes")
public class QuizController {

    private final QuizService quizService;

    @PostMapping("/create")
    public ApiSuccessResponse<?> createQuiz(@RequestBody QuizCreateRequest request) {
        quizService.createQuiz(request);
        return ApiSuccessResponse.NO_DATA_RESPONSE;
    }

    @GetMapping("/getAll")
    public ApiSuccessResponse<List<QuizResponse>> getAllQuiz() {
        return ApiSuccessResponse.from(quizService.getAll());
    }
}
