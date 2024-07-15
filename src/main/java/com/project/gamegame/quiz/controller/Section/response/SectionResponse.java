package com.project.gamegame.quiz.controller.Section.response;

import com.project.gamegame.quiz.domain.ObjectiveQuestion;
import com.project.gamegame.quiz.domain.Section;
import com.project.gamegame.quiz.domain.SubjectiveQuestion;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SectionResponse {

    private Long id;

    private String title;


    public static SectionResponse fromEntity(Section section) {
        return SectionResponse.builder()
                .id(section.getId())
                .title(section.getTitle())
                .build();
    }
}
