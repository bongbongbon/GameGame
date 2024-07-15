package com.project.gamegame.quiz.domain;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@SuperBuilder
@DiscriminatorValue("OBJECTIVE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObjectiveQuestion extends Question {
    @ElementCollection
    private List<String> options;

    private String correctAnswer;
}
