package com.esprit.referentielservice.web.Service.Interfaces;

import com.esprit.referentielservice.web.model.ActivitySector;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IActivitySectorService {
    ResponseEntity<List<ActivitySector>> findAll();
    ResponseEntity<ActivitySector> findById(Long id);
    ResponseEntity<ActivitySector> add(ActivitySector activitySector);
    ResponseEntity<ActivitySector> update(ActivitySector activitySector);
    ResponseEntity<Boolean> delete(Long id);
}
