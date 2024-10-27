package com.esprit.scoringservice.web.repository;


import com.esprit.scoringservice.web.model.ClientSegmentConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClientSegmentConfigRepository extends JpaRepository<ClientSegmentConfig, Long> {
    ClientSegmentConfig findClientSegmentConfigBySegmentCode (String code);
}
