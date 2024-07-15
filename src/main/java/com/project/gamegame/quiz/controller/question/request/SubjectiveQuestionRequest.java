package com.project.gamegame.quiz.controller.question.request;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectiveQuestionRequest {

    private String title;
    private String correctAnswer;
}
