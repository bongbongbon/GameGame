package com.project.gamegame.quiz.repository;

import com.project.gamegame.quiz.domain.SubjectiveQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectiveQuestionRepository extends JpaRepository<SubjectiveQuestion, Long> {

}
