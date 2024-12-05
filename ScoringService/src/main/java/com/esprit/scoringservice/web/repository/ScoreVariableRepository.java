package com.esprit.scoringservice.web.repository;

import com.esprit.scoringservice.web.model.Retail;
import com.esprit.scoringservice.web.model.ScoreVariable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ScoreVariableRepository extends JpaRepository<ScoreVariable, Long> {
}
