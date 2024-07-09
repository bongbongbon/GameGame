package com.project.gamegame.quiz.service;

import com.project.gamegame.quiz.controller.ObjectiveQuestion.request.ObjectiveQuestionRequest;
import com.project.gamegame.quiz.controller.ObjectiveQuestion.response.ObjectiveQuestionResponse;
import com.project.gamegame.quiz.domain.ObjectiveQuestion;
import com.project.gamegame.quiz.repository.ObjectiveQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ObjectiveQuestionService {

    private final ObjectiveQuestionRepository objectiveQuestionRepository;

    // 객관식 문제 다 가져오기
    public List<ObjectiveQuestionResponse> getAllQuestions() {

        return ObjectiveQuestionResponse.fromEntity(objectiveQuestionRepository.findAll());
    }

    // 객관식 문제 하나만 가져오기
    public ObjectiveQuestionResponse getQuestionById(Long id) {


        return ObjectiveQuestionResponse.fromEntity(objectiveQuestionRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("객관식 문제 없음")));
    }


    // 객관식 문제 만들기
    public ObjectiveQuestionResponse createQuestion(ObjectiveQuestionRequest request) {

        ObjectiveQuestion objectiveQuestion = ObjectiveQuestion.builder()
                .question(request.getQuestion())
                .correctAnswer(request.getCorrectAnswer())
                .options(request.getOptions())
                .build();

        return ObjectiveQuestionResponse.fromEntity(objectiveQuestionRepository.save(objectiveQuestion));
    }

    // 객관식 문제 수정
    public ObjectiveQuestionResponse updateQuestion(Long id, ObjectiveQuestionRequest request) {
        ObjectiveQuestion objectiveQuestion = objectiveQuestionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("객관식 문제 없음"));

        objectiveQuestion.setQuestion(request.getQuestion());
        objectiveQuestion.setOptions(request.getOptions());
        objectiveQuestion.setCorrectAnswer(request.getCorrectAnswer());
        return ObjectiveQuestionResponse.fromEntity(objectiveQuestionRepository.save(objectiveQuestion));
    }

    // 객관식 문제 삭제
    public void deleteQuestion(Long id) {
        ObjectiveQuestion objectiveQuestion = objectiveQuestionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("객관식 문제 없음"));

        objectiveQuestionRepository.delete(objectiveQuestion);
    }
}
