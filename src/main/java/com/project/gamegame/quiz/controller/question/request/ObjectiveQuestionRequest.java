package com.project.gamegame.quiz.controller.question.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObjectiveQuestionRequest {

    private String text;
    private List<String> options;
    private String correctAnswer;
    private Long sectionId;
}
