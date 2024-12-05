package com.esprit.referentielservice.web.controller;

import com.esprit.referentielservice.web.Service.Interfaces.IActivitySectorService;
import com.esprit.referentielservice.web.model.ActivitySector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Referentiel/ActivitySector")
//@CrossOrigin(origins = "http://localhost:4200")
public class ActivitySectorController {
    @Autowired
    IActivitySectorService activitySectorService;
    @GetMapping
    private ResponseEntity<List<ActivitySector>> findAll() {
        return activitySectorService.findAll();
    }
    @GetMapping("/{id}")
    private ResponseEntity<ActivitySector> findById(@PathVariable("id") Long id) {
        return activitySectorService.findById(id);
    }
    @PostMapping
    private ResponseEntity<ActivitySector> add(@RequestBody ActivitySector activitySector) {
        return activitySectorService.add(activitySector);
    }
    @PutMapping
    private ResponseEntity<ActivitySector> update(@RequestBody ActivitySector activitySector) {
        return activitySectorService.update(activitySector);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return activitySectorService.delete(id);
    }
}
