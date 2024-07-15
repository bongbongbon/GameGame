package com.project.gamegame.quiz.controller.Section.response;

import com.project.gamegame.quiz.controller.question.response.ObjectiveQuestionResponse;
import com.project.gamegame.quiz.controller.question.response.SubjectiveQuestionResponse;
import com.project.gamegame.quiz.domain.ObjectiveQuestion;
import com.project.gamegame.quiz.domain.Section;
import com.project.gamegame.quiz.domain.SubjectiveQuestion;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SectionResponse {

    private Long id;

    private String title;

    private List<ObjectiveQuestionResponse> objectiveQuestionResponseList = new ArrayList<>();

    private List<SubjectiveQuestionResponse> subjectiveQuestionResponseList = new ArrayList<>();



    public static SectionResponse fromEntity(Section section) {
        SectionResponseBuilder builder = SectionResponse.builder()
                .id(section.getId())
                .title(section.getTitle());

        if (section.getObjectiveQuestionList() != null) {
            builder.objectiveQuestionResponseList(ObjectiveQuestionResponse.fromEntity(section.getObjectiveQuestionList()));
        }

        if (section.getSubjectiveQuestionList() != null) {
            builder.subjectiveQuestionResponseList(SubjectiveQuestionResponse.fromEntity(section.getSubjectiveQuestionList()));
        }

        return builder.build();
    }

    public static List<SectionResponse> fromEntity(List<Section> section) {
        return section.stream()
                .map(SectionResponse::fromEntity)
                .collect(Collectors.toList());
    }
}
