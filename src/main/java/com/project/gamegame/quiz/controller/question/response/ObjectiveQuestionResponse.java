package com.project.gamegame.quiz.controller.question.response;

import com.project.gamegame.quiz.controller.Section.response.SectionResponse;
import com.project.gamegame.quiz.domain.ObjectiveQuestion;
import com.project.gamegame.quiz.domain.Section;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObjectiveQuestionResponse {

    private Long id;
    private String title;
    private List<String> options;
    private String correctAnswer;

    public static ObjectiveQuestionResponse fromEntity(ObjectiveQuestion objectiveQuestion) {
        return ObjectiveQuestionResponse.builder()
                .id(objectiveQuestion.getId())
                .title(objectiveQuestion.getTitle())
                .options(objectiveQuestion.getOptions())
                .correctAnswer(objectiveQuestion.getCorrectAnswer())
                .build();
    }

    public static List<ObjectiveQuestionResponse> fromEntity(List<ObjectiveQuestion> objectiveQuestionList) {
        return objectiveQuestionList.stream()
                .map(ObjectiveQuestionResponse::fromEntity)
                .collect(Collectors.toList());
    }
}
