package com.project.gamegame.quiz.controller.question.request;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectiveQuestionRequest {

    private String text;
    private String correctAnswer;
    private Long sectionId;
}
