package com.esprit.referentielservice.web.Service.Interfaces;

import com.esprit.referentielservice.web.model.FinancingType;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IFinancingTypeService {
    ResponseEntity<List<FinancingType>> findAll();
    ResponseEntity<FinancingType> findById(Long id);
    ResponseEntity<FinancingType> findByFinancingTypeCode(String financingTypeCode);
    ResponseEntity<List<FinancingType>> findFinancingTypeByFinancingNature_ProjectNature(String financingNature);

    ResponseEntity<FinancingType> add(FinancingType financingType);
    ResponseEntity<FinancingType> update(FinancingType financingType);
    ResponseEntity<Boolean> delete(Long id);
}
