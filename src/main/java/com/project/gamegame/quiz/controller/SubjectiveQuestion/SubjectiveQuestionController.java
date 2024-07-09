package com.project.gamegame.quiz.controller.SubjectiveQuestion;

import com.project.gamegame.quiz.controller.ObjectiveQuestion.request.ObjectiveQuestionRequest;
import com.project.gamegame.quiz.controller.SubjectiveQuestion.request.SubjectiveQuestionRequest;
import com.project.gamegame.quiz.domain.SubjectiveQuestion;
import com.project.gamegame.quiz.service.ObjectiveQuestionService;
import com.project.gamegame.quiz.service.SubjectiveQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/subjective")
public class SubjectiveQuestionController {

    private final SubjectiveQuestionService subjectiveQuestionService;

    @GetMapping("/questions")
    public ResponseEntity<?> getAllQuestions() {

        return ResponseEntity.ok().body(subjectiveQuestionService.getAllQuestions());
    }

    @GetMapping("/questions/{id}")
    public ResponseEntity<?> getQuestionById(@PathVariable Long id) {

        return ResponseEntity.ok().body(subjectiveQuestionService.getQuestionById(id));
    }

    @PostMapping("/questions")
    public ResponseEntity<?> createQuestion(@RequestBody SubjectiveQuestionRequest request) {

        return ResponseEntity.ok().body(subjectiveQuestionService.createQuestion(request));
    }

    @PutMapping("/questions/{id}")
    public ResponseEntity<?> updateQuestion(@PathVariable Long id, @RequestBody SubjectiveQuestionRequest request) {
        return ResponseEntity.ok().body(subjectiveQuestionService.updateQuestion(id, request));
    }

    @DeleteMapping("/questions/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        subjectiveQuestionService.deleteQuestion(id);
    }
}
