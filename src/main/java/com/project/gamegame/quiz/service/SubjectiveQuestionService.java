package com.project.gamegame.quiz.service;

import com.project.gamegame.common.exception.CustomException;
import com.project.gamegame.quiz.controller.ObjectiveQuestion.request.ObjectiveQuestionRequest;
import com.project.gamegame.quiz.controller.ObjectiveQuestion.response.ObjectiveQuestionResponse;
import com.project.gamegame.quiz.controller.SubjectiveQuestion.request.SubjectiveQuestionRequest;
import com.project.gamegame.quiz.controller.SubjectiveQuestion.response.SubjectiveQuestionResponse;
import com.project.gamegame.quiz.domain.ObjectiveQuestion;
import com.project.gamegame.quiz.domain.SubjectiveQuestion;
import com.project.gamegame.quiz.repository.ObjectiveQuestionRepository;
import com.project.gamegame.quiz.repository.SubjectiveQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectiveQuestionService {

    private final SubjectiveQuestionRepository subjectiveQuestionRepository;

    // 주관식 문제 다 가져오기
    public List<SubjectiveQuestionResponse> getAllQuestions() {

        return SubjectiveQuestionResponse.fromEntity(subjectiveQuestionRepository.findAll());
    }

    // 객관식 문제 하나만 가져오기
    public SubjectiveQuestionResponse getQuestionById(Long id) {


        return SubjectiveQuestionResponse.fromEntity(subjectiveQuestionRepository.findById(id)
                .orElseThrow(()-> CustomException.SUBJECTIVE_QUESTION_NOT_FOUND));
    }


    // 객관식 문제 만들기
    public SubjectiveQuestionResponse createQuestion(SubjectiveQuestionRequest request) {

        SubjectiveQuestion subjectiveQuestion = SubjectiveQuestion.builder()
                .question(request.getQuestion())
                .answer(request.getAnswer())
                .build();

        return SubjectiveQuestionResponse.fromEntity(subjectiveQuestionRepository.save(subjectiveQuestion));
    }

    // 객관식 문제 수정
    public SubjectiveQuestionResponse updateQuestion(Long id, SubjectiveQuestionRequest request) {
        SubjectiveQuestion subjectiveQuestion = subjectiveQuestionRepository.findById(id)
                .orElseThrow(() -> CustomException.SUBJECTIVE_QUESTION_NOT_FOUND);

        subjectiveQuestion.setQuestion(request.getQuestion());
        subjectiveQuestion.setAnswer(request.getAnswer());
        return SubjectiveQuestionResponse.fromEntity(subjectiveQuestionRepository.save(subjectiveQuestion));
    }

    // 객관식 문제 삭제
    public void deleteQuestion(Long id) {
        SubjectiveQuestion subjectiveQuestion = subjectiveQuestionRepository.findById(id)
                .orElseThrow(() -> CustomException.SUBJECTIVE_QUESTION_NOT_FOUND);

        subjectiveQuestionRepository.delete(subjectiveQuestion);
    }

}
