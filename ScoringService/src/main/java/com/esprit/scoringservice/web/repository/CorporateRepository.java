package com.esprit.scoringservice.web.repository;

import com.esprit.scoringservice.web.model.Corporate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateRepository extends JpaRepository <Corporate, Long> {
}
