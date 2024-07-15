package com.project.gamegame.quiz.controller.question;

import com.project.gamegame.quiz.controller.question.request.ObjectiveQuestionRequest;
import com.project.gamegame.quiz.controller.question.request.SubjectiveQuestionRequest;
import com.project.gamegame.quiz.controller.question.response.ObjectiveQuestionResponse;
import com.project.gamegame.quiz.controller.question.response.SubjectiveQuestionResponse;
import com.project.gamegame.quiz.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/objective/{sectionId}")
    public ResponseEntity<ObjectiveQuestionResponse> createObjectiveQuestion(@RequestBody ObjectiveQuestionRequest request,
                                                                             @PathVariable(name = "sectionId") Long sectionId) {
        ObjectiveQuestionResponse question = questionService.createObjectiveQuestion(request, sectionId);
        return ResponseEntity.ok(question);
    }

    @PostMapping("/subjective/{sectionId}")
    public ResponseEntity<SubjectiveQuestionResponse> createSubjectiveQuestion(@RequestBody SubjectiveQuestionRequest request,
                                                                               @PathVariable(name = "sectionId") Long sectionId) {
        SubjectiveQuestionResponse question = questionService.createSubjectiveQuestion(request, sectionId);
        return ResponseEntity.ok(question);
    }







}
