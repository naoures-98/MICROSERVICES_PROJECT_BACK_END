package com.esprit.scoringservice.web.service.interfaces;

import com.esprit.scoringservice.web.model.ClientSegmentConfig;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IClientSegmentConfigService {
    ResponseEntity<List<ClientSegmentConfig>> findAll();
    ResponseEntity<ClientSegmentConfig> findById(Long id);
    ResponseEntity<ClientSegmentConfig> findClientSegmentConfigBySegmentCode(String  code);
    ResponseEntity<ClientSegmentConfig> add(ClientSegmentConfig clientSegmentConfig);
    ResponseEntity<ClientSegmentConfig> update(ClientSegmentConfig clientSegmentConfig);
    ResponseEntity<Boolean> delete(Long id);
}
