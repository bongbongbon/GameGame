package com.project.gamegame.quiz.service;

import com.project.gamegame.common.exception.CustomException;
import com.project.gamegame.quiz.controller.question.request.ObjectiveQuestionRequest;
import com.project.gamegame.quiz.controller.question.request.SubjectiveQuestionRequest;
import com.project.gamegame.quiz.controller.question.response.ObjectiveQuestionResponse;
import com.project.gamegame.quiz.controller.question.response.SubjectiveQuestionResponse;
import com.project.gamegame.quiz.domain.ObjectiveQuestion;
import com.project.gamegame.quiz.domain.Section;
import com.project.gamegame.quiz.domain.SubjectiveQuestion;
import com.project.gamegame.quiz.repository.ObjectiveQuestionRepository;
import com.project.gamegame.quiz.repository.SectionRepository;
import com.project.gamegame.quiz.repository.SubjectiveQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final SectionRepository sectionRepository;

    private final ObjectiveQuestionRepository objectiveQuestionRepository;

    private final SubjectiveQuestionRepository subjectiveQuestionRepository;

    public ObjectiveQuestionResponse createObjectiveQuestion(ObjectiveQuestionRequest request, Long sectionId) {
        Section section = sectionRepository.findById(sectionId)
                .orElseThrow(() -> CustomException.SECTION_NOT_FOUND);

        ObjectiveQuestion objectiveQuestion = ObjectiveQuestion.builder()
                .title(request.getTitle())
                .correctAnswer(request.getCorrectAnswer())
                .options(request.getOptions())
                .section(section)
                .build();

        return ObjectiveQuestionResponse.fromEntity(objectiveQuestionRepository.save(objectiveQuestion));
    }

    public SubjectiveQuestionResponse createSubjectiveQuestion(SubjectiveQuestionRequest request, Long sectionId) {
        Section section = sectionRepository.findById(sectionId)
                .orElseThrow(() -> CustomException.SECTION_NOT_FOUND);

        SubjectiveQuestion subjectiveQuestion = SubjectiveQuestion.builder()
                .title(request.getTitle())
                .correctAnswer(request.getCorrectAnswer())
                .section(section)
                .build();

        return SubjectiveQuestionResponse.fromEntity(subjectiveQuestionRepository.save(subjectiveQuestion));
    }
}
