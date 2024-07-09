package com.project.gamegame.quiz.controller.ObjectiveQuestion;


import com.project.gamegame.quiz.controller.ObjectiveQuestion.request.ObjectiveQuestionRequest;
import com.project.gamegame.quiz.domain.ObjectiveQuestion;
import com.project.gamegame.quiz.service.ObjectiveQuestionService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/objective")
public class ObjectiveQuestionController {

    private final ObjectiveQuestionService objectiveQuestionService;

    @GetMapping("/questions")
    public ResponseEntity<?> getAllQuestions() {

        return ResponseEntity.ok().body(objectiveQuestionService.getAllQuestions());
    }

    @GetMapping("/questions/{id}")
    public ResponseEntity<?> getQuestionById(@PathVariable Long id) {

        return ResponseEntity.ok().body(objectiveQuestionService.getQuestionById(id));
    }

    @PostMapping("/questions")
    public ResponseEntity<?> createQuestion(@RequestBody ObjectiveQuestionRequest request) {

        return ResponseEntity.ok().body(objectiveQuestionService.createQuestion(request));
    }

    @PutMapping("/questions/{id}")
    public ResponseEntity<?> updateQuestion(@PathVariable Long id, @RequestBody ObjectiveQuestionRequest request) {
        return ResponseEntity.ok().body(objectiveQuestionService.updateQuestion(id, request));
    }

    @DeleteMapping("/questions/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        objectiveQuestionService.deleteQuestion(id);
    }
}
