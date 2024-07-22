package com.project.gamegame.quiz.controller;

import com.project.gamegame.common.response.ApiSuccessResponse;
import com.project.gamegame.quiz.domain.Quiz;
import com.project.gamegame.quiz.dto.quiz.QuizCheckAnswerRequest;
import com.project.gamegame.quiz.dto.quiz.QuizCreateRequest;
import com.project.gamegame.quiz.dto.quiz.QuizResponse;
import com.project.gamegame.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    // page처리로 퀴즈 전부 가져오기
    @GetMapping("/getAll")
    public ApiSuccessResponse<?> getAllQuizzes(@RequestParam(name = "page") int page,
                                               @RequestParam(name = "size") int size) {
        return ApiSuccessResponse.from(quizService.getQuizzes(page, size));
    }

    @GetMapping("/get/{id}")
    public ApiSuccessResponse<?> getQuiz(@PathVariable(name = "id") Long quizId) {
        return ApiSuccessResponse.from(quizService.getQuiz(quizId));
    }


    @PostMapping("/checkAnswer")
    public ApiSuccessResponse<?> checkAnswer(@RequestBody QuizCheckAnswerRequest request) {

        return ApiSuccessResponse.from(quizService.checkAnswer(request));
    }


}
