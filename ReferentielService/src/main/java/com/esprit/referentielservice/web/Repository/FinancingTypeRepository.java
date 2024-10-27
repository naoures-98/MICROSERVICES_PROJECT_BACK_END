package com.esprit.referentielservice.web.Repository;

import com.esprit.referentielservice.web.model.Branch;
import com.esprit.referentielservice.web.model.FinancingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancingTypeRepository extends JpaRepository<FinancingType, Long> {

    public FinancingType findFinancingTypeByFinancingTypeCode(String financingTypeCode);
    public List <FinancingType> findFinancingTypeByFinancingNature_ProjectNature(String financingNature);
}
