package com.project.gamegame.quiz.controller.ObjectiveQuestion.request;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObjectiveQuestionRequest {

    private String question;

    private List<String> options = new ArrayList<>();

    private String correctAnswer;
}
