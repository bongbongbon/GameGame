package com.project.gamegame.quiz.service;

import com.project.gamegame.common.exception.CustomException;
import com.project.gamegame.quiz.controller.Section.request.SectionRequest;
import com.project.gamegame.quiz.controller.Section.response.SectionResponse;
import com.project.gamegame.quiz.domain.Section;
import com.project.gamegame.quiz.repository.ObjectiveQuestionRepository;
import com.project.gamegame.quiz.repository.SectionRepository;
import com.project.gamegame.quiz.repository.SubjectiveQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectionService {

    private final SectionRepository sectionRepository;

    private final ObjectiveQuestionRepository objectiveQuestionRepository;

    private SubjectiveQuestionRepository subjectiveQuestionRepository;


    public SectionResponse createSection(SectionRequest sectionRequest) {

        Section section = Section.builder()
                .title(sectionRequest.getTitle())
                .build();
        return SectionResponse.fromEntity(sectionRepository.save(section));
    }

    public List<SectionResponse> getAllSections() {
        return SectionResponse.fromEntity(sectionRepository.findAll());
    }

    public SectionResponse getSection(Long id) {
        return SectionResponse.fromEntity(sectionRepository.findById(id)
                .orElseThrow(() -> CustomException.SECTION_NOT_FOUND));
    }




}
