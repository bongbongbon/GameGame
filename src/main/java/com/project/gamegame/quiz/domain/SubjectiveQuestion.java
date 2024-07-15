package com.project.gamegame.quiz.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Entity
@SuperBuilder
@DiscriminatorValue("SUBJECTIVE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectiveQuestion extends Question{

    private String correctAnswer;
}
