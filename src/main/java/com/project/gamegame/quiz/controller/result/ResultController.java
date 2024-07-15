package com.project.gamegame.quiz.controller.result;

import com.project.gamegame.quiz.controller.result.request.ResultRequest;
import com.project.gamegame.quiz.controller.result.response.ResultResponse;
import com.project.gamegame.quiz.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/results")
public class ResultController {

    private final ResultRepository resultRepository;



}
