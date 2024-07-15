package com.project.gamegame.quiz.repository;

import com.project.gamegame.quiz.domain.ObjectiveQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectiveQuestionRepository extends JpaRepository<ObjectiveQuestion, Long> {

}
