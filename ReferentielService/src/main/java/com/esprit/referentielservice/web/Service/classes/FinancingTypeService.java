package com.esprit.referentielservice.web.Service.classes;

import com.esprit.referentielservice.web.Repository.FinancingTypeRepository;
import com.esprit.referentielservice.web.Service.Interfaces.IFinancingTypeService;
import com.esprit.referentielservice.web.model.FinancingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class FinancingTypeService implements IFinancingTypeService {
    @Autowired
    FinancingTypeRepository financingTypeRepository;

    public FinancingTypeService(FinancingTypeRepository financingTypeRepository) {
        this.financingTypeRepository = financingTypeRepository;
    }

    @Override
    public ResponseEntity<List<FinancingType>> findAll() {
        try {
            return new ResponseEntity<>(financingTypeRepository.findAll(), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(FinancingTypeService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public ResponseEntity<List<FinancingType>> findFinancingTypeByFinancingNature_ProjectNature(String financingNatureCode) {
        try {
            return new ResponseEntity<>(financingTypeRepository.findFinancingTypeByFinancingNature_ProjectNature(financingNatureCode), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(FinancingTypeService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public ResponseEntity<FinancingType> findById(Long id) {
        try {
            return new ResponseEntity(financingTypeRepository.findById(id).orElse(null), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(FinancingTypeService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public ResponseEntity<FinancingType> findByFinancingTypeCode(String financingTypeCode) {
        try {
            return new ResponseEntity(financingTypeRepository.findFinancingTypeByFinancingTypeCode(financingTypeCode), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(FinancingTypeService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<FinancingType> add(FinancingType financingType) {
        try {
            return new ResponseEntity(financingTypeRepository.save(financingType), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(FinancingTypeService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<FinancingType> update(FinancingType financingType) {
        try {
            return new ResponseEntity(financingTypeRepository.save(financingType), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(FinancingTypeService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        try {
            if (financingTypeRepository.existsById(id)) {
                financingTypeRepository.deleteById(id);
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
            return new ResponseEntity<>(false, HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(FinancingTypeService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
