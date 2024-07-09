package com.project.gamegame.quiz.controller.ObjectiveQuestion.response;

import com.project.gamegame.quiz.domain.ObjectiveQuestion;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObjectiveQuestionResponse {

    private String question;

    private List<String> options = new ArrayList<>();

    private String correctAnswer;

    public static ObjectiveQuestionResponse fromEntity(ObjectiveQuestion objectiveQuestion) {
        return ObjectiveQuestionResponse.builder()
                .question(objectiveQuestion.getQuestion())
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
