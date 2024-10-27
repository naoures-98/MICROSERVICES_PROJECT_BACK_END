package com.esprit.scoringservice.web.repository;

import com.esprit.scoringservice.web.model.Retail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailRepository extends JpaRepository <Retail, Long> {
}
