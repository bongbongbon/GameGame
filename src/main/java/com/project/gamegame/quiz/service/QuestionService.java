package com.project.gamegame.quiz.service;

import com.project.gamegame.common.exception.CustomException;
import com.project.gamegame.quiz.controller.question.request.ObjectiveQuestionRequest;
import com.project.gamegame.quiz.controller.question.request.SubjectiveQuestionRequest;
import com.project.gamegame.quiz.controller.question.response.ObjectiveQuestionResponse;
import com.project.gamegame.quiz.controller.question.response.SubjectiveQuestionResponse;
import com.project.gamegame.quiz.domain.ObjectiveQuestion;
import com.project.gamegame.quiz.domain.Question;
import com.project.gamegame.quiz.domain.Section;
import com.project.gamegame.quiz.domain.SubjectiveQuestion;
import com.project.gamegame.quiz.repository.QuestionRepository;
import com.project.gamegame.quiz.repository.SectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final SectionRepository sectionRepository;

    public ObjectiveQuestionResponse createObjectiveQuestion(ObjectiveQuestionRequest request) {
        Section section = sectionRepository.findById(request.getSectionId())
                .orElseThrow(() -> CustomException.SECTION_NOT_FOUND);


        ObjectiveQuestion objectiveQuestion = ObjectiveQuestion.builder()
                .text(request.getText())
                .options(request.getOptions())
                .correctAnswer(request.getCorrectAnswer())
                .section(section)
                .build();

        return ObjectiveQuestionResponse.fromEntity(objectiveQuestion);
    }

    public SubjectiveQuestionResponse createSubjectiveQuestion(SubjectiveQuestionRequest request) {
        Section section = sectionRepository.findById(request.getSectionId())
                .orElseThrow(() -> CustomException.SECTION_NOT_FOUND);

        SubjectiveQuestion subjectiveQuestion = SubjectiveQuestion.builder()
                .text(request.getText())
                .correctAnswer(request.getCorrectAnswer())
                .section(section)
                .build();

        return SubjectiveQuestionResponse.fromEntity(subjectiveQuestion);
    }

}
