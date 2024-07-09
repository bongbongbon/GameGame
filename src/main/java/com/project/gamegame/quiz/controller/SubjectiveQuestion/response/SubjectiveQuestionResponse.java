package com.project.gamegame.quiz.controller.SubjectiveQuestion.response;


import com.project.gamegame.quiz.controller.ObjectiveQuestion.response.ObjectiveQuestionResponse;
import com.project.gamegame.quiz.domain.ObjectiveQuestion;
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
public class SubjectiveQuestionResponse {

    private String question;

    private String answer;

    public static SubjectiveQuestionResponse fromEntity(SubjectiveQuestion subjectiveQuestion) {
        return SubjectiveQuestionResponse.builder()
                .question(subjectiveQuestion.getQuestion())
                .answer(subjectiveQuestion.getAnswer())
                .build();
    }

    public static List<SubjectiveQuestionResponse> fromEntity(List<SubjectiveQuestion> subjectiveQuestionList) {
        return subjectiveQuestionList.stream()
                .map(SubjectiveQuestionResponse::fromEntity)
                .collect(Collectors.toList());
    }
}
