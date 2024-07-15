package com.project.gamegame.quiz.service;

import com.project.gamegame.common.exception.CustomException;
import com.project.gamegame.quiz.controller.Section.request.SectionRequest;
import com.project.gamegame.quiz.controller.Section.response.SectionResponse;
import com.project.gamegame.quiz.domain.Section;
import com.project.gamegame.quiz.repository.SectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectionService {

    private final SectionRepository sectionRepository;

    public SectionResponse createSection(SectionRequest sectionRequest) {

        Section section = Section.builder()
                .title(sectionRequest.getTitle())
                .build();
        return SectionResponse.fromEntity(sectionRepository.save(section));
    }

    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    public Section getSection(Long id) {
        return sectionRepository.findById(id)
                .orElseThrow(() -> CustomException.SECTION_NOT_FOUND);
    }

}
