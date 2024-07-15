package com.project.gamegame.quiz.controller.question.response;

import com.project.gamegame.quiz.controller.Section.response.SectionResponse;
import com.project.gamegame.quiz.domain.ObjectiveQuestion;
import com.project.gamegame.quiz.domain.Section;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObjectiveQuestionResponse {

    private Long id;
    private String text;
    private List<String> options;
    private String correctAnswer;
    private Long sectionId;

    public static ObjectiveQuestionResponse fromEntity(ObjectiveQuestion objectiveQuestion) {
        return ObjectiveQuestionResponse.builder()
                .id(objectiveQuestion.getId())
                .text(objectiveQuestion.getText())
                .options(objectiveQuestion.getOptions())
                .correctAnswer(objectiveQuestion.getCorrectAnswer())
                .sectionId(objectiveQuestion.getSection().getId())
                .build();
    }
}
