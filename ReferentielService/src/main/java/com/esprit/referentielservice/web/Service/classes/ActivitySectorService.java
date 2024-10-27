package com.esprit.referentielservice.web.Service.classes;

import com.esprit.referentielservice.web.Repository.ActivitySectorRepository;
import com.esprit.referentielservice.web.Service.Interfaces.IActivitySectorService;
import com.esprit.referentielservice.web.model.ActivitySector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ActivitySectorService implements IActivitySectorService {
    @Autowired
    ActivitySectorRepository activitySectorRepository;

    public ActivitySectorService(ActivitySectorRepository activitySectorRepository) {
        this.activitySectorRepository = activitySectorRepository;
    }

    @Override
    public ResponseEntity<List<ActivitySector>> findAll() {
        try {
            return new ResponseEntity<>(activitySectorRepository.findAll(), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ActivitySectorService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ActivitySector> findById(Long id) {
        try {
            return new ResponseEntity(activitySectorRepository.findById(id).orElse(null), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ActivitySectorService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ActivitySector> add(ActivitySector activitySector) {
        try {
            return new ResponseEntity(activitySectorRepository.save(activitySector), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ActivitySectorService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ActivitySector> update(ActivitySector activitySector) {
        try {
            return new ResponseEntity(activitySectorRepository.save(activitySector), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ActivitySectorService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        try {
            if (activitySectorRepository.existsById(id)) {
                activitySectorRepository.deleteById(id);
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
            return new ResponseEntity<>(false, HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ActivitySectorService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
