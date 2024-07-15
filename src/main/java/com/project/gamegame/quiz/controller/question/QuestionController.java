package com.project.gamegame.quiz.controller.question;

import com.project.gamegame.quiz.controller.question.request.ObjectiveQuestionRequest;
import com.project.gamegame.quiz.controller.question.request.SubjectiveQuestionRequest;
import com.project.gamegame.quiz.controller.question.response.ObjectiveQuestionResponse;
import com.project.gamegame.quiz.controller.question.response.SubjectiveQuestionResponse;
import com.project.gamegame.quiz.domain.ObjectiveQuestion;
import com.project.gamegame.quiz.domain.Question;
import com.project.gamegame.quiz.domain.SubjectiveQuestion;
import com.project.gamegame.quiz.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;


    @PostMapping("/objective")
    public ResponseEntity<ObjectiveQuestionResponse> createObjectiveQuestion(@RequestBody ObjectiveQuestionRequest request) {
        ObjectiveQuestionResponse question = questionService.createObjectiveQuestion(request);
        return ResponseEntity.ok(question);
    }

    @PostMapping("/subjective")
    public ResponseEntity<SubjectiveQuestionResponse> createSubjectiveQuestion(@RequestBody SubjectiveQuestionRequest request) {
        SubjectiveQuestionResponse question = questionService.createSubjectiveQuestion(request);
        return ResponseEntity.ok(question);
    }
}
