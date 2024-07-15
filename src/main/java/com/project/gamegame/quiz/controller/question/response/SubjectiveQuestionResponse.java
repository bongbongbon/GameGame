package com.project.gamegame.quiz.controller.question.response;

import com.project.gamegame.quiz.domain.ObjectiveQuestion;
import com.project.gamegame.quiz.domain.Section;
import com.project.gamegame.quiz.domain.SubjectiveQuestion;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectiveQuestionResponse {

    private Long id;
    private String title;
    private String correctAnswer;

    public static SubjectiveQuestionResponse fromEntity(SubjectiveQuestion subjectiveQuestion) {
        return SubjectiveQuestionResponse.builder()
                .id(subjectiveQuestion.getId())
                .title(subjectiveQuestion.getTitle())
                .correctAnswer(subjectiveQuestion.getCorrectAnswer())
                .build();
    }

    public static List<SubjectiveQuestionResponse> fromEntity(List<SubjectiveQuestion> subjectiveQuestionList) {
        return subjectiveQuestionList.stream()
                .map(SubjectiveQuestionResponse::fromEntity)
                .collect(Collectors.toList());
    }
}
