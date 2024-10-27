package com.esprit.referentielservice.web.Service.classes;

import com.esprit.referentielservice.web.Repository.FinancingNatureRepository;
import com.esprit.referentielservice.web.Service.Interfaces.IFinancingNatureService;
import com.esprit.referentielservice.web.model.FinancingNature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class FinancingNatureService implements IFinancingNatureService {
    @Autowired
    FinancingNatureRepository financingNatureRepository;

    public FinancingNatureService(FinancingNatureRepository financingNatureRepository) {
        this.financingNatureRepository = financingNatureRepository;
    }

    @Override
    public ResponseEntity<List<FinancingNature>> findAll() {
        try {
            return new ResponseEntity<>(financingNatureRepository.findAll(), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(FinancingNatureService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<FinancingNature> findById(Long id) {
        try {
            return new ResponseEntity(financingNatureRepository.findById(id).orElse(null), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(FinancingNatureService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<FinancingNature> add(FinancingNature financingNature) {
        try {
            return new ResponseEntity(financingNatureRepository.save(financingNature), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(FinancingNatureService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<FinancingNature> update(FinancingNature financingNature) {
        try {
            return new ResponseEntity(financingNatureRepository.save(financingNature), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(FinancingNatureService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        try {
            if (financingNatureRepository.existsById(id)) {
                financingNatureRepository.deleteById(id);
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
            return new ResponseEntity<>(false, HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(FinancingNatureService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
