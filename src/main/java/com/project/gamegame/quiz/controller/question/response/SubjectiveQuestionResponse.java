package com.project.gamegame.quiz.controller.question.response;

import com.project.gamegame.quiz.domain.ObjectiveQuestion;
import com.project.gamegame.quiz.domain.SubjectiveQuestion;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectiveQuestionResponse {

    private Long id;
    private String text;
    private String correctAnswer;
    private Long sectionId;

    public static SubjectiveQuestionResponse fromEntity(SubjectiveQuestion subjectiveQuestion) {
        return SubjectiveQuestionResponse.builder()
                .id(subjectiveQuestion.getId())
                .text(subjectiveQuestion.getText())
                .correctAnswer(subjectiveQuestion.getCorrectAnswer())
                .sectionId(subjectiveQuestion.getSection().getId())
                .build();
    }
}
