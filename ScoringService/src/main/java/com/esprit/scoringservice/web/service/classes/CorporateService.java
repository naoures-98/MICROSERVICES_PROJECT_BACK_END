package com.esprit.scoringservice.web.service.classes;

import com.esprit.scoringservice.web.client.*;
import com.esprit.scoringservice.web.dto.*;
import com.esprit.scoringservice.web.model.Corporate;
import com.esprit.scoringservice.web.model.Retail;
import com.esprit.scoringservice.web.repository.CorporateRepository;
import com.esprit.scoringservice.web.service.interfaces.ICorporateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
@Service
public class CorporateService implements ICorporateService {
    @Autowired
    CorporateRepository corporateRepository;

    @Autowired
    private CurrencyClient currencyClient ;
    @Autowired
    private FinancingTypeClient financingTypeClient ;
    @Autowired
    private BranchClient branchClient ;
    @Autowired
    private JuridicalFormClient juridicalFormClient ;
    @Autowired
    private ActivitySectorClient activitySectorClient ;

    public CorporateService(CorporateRepository corporateRepository) {
        this.corporateRepository = corporateRepository;
    }

    @Override
    public ResponseEntity<List<Corporate>> findAll() {
        try {
            return new ResponseEntity<>(corporateRepository.findAll(), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(CorporateService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Corporate> findById(Long id) {
        try {
            return new ResponseEntity(corporateRepository.findById(id).orElse(null), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(CorporateService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Corporate> add(Corporate corporate) {
        try {
            return new ResponseEntity(corporateRepository.save(corporate), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(CorporateService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Corporate> update(Corporate corporate) {
        try {
            return new ResponseEntity(corporateRepository.save(corporate), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(CorporateService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        try {
            if (corporateRepository.existsById(id)) {
                corporateRepository.deleteById(id);
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
            return new ResponseEntity<>(false, HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(CorporateService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public ResponseEntity<?> findCorporateWithAllRelations(Long id) {
        Optional<Corporate> corporate =  corporateRepository.findById(id);
        if(corporate.isPresent()){
            Currency currency = currencyClient.findAllScoringContractDataByCurrency(corporate.get().getCurrencyId());
            Branch branch = branchClient.findAllScoringContractDataByBranch(corporate.get().getBranchId());
            System.out.println("getFinancingTypeId = "+ corporate.get().getFinancingTypeId());
            FinancingType financingType = financingTypeClient.findAllScoringContractDataByFinancingType(corporate.get().getFinancingTypeId());
            JuridicalForm juridicalForm = juridicalFormClient.findAllScoringContractDataByJuridicalForm(corporate.get().getJuridicalFormId());
            ActivitySector activitySector = activitySectorClient.findAllScoringContractDataByActivitySector(corporate.get().getActivitySectorId());

            FullCorporateResponse fullCorporateResponseResponse = new FullCorporateResponse(
                    //retail.get().getId(),
                    corporate.get().getRaisonSocial(),
                    corporate.get().getClientCategory(),
                    corporate.get().getCreationDate(),
                    corporate.get().getCreationPlace(),
                    corporate.get().getNumNis(),
                    corporate.get().getNumRegistreCommerce(),
                    corporate.get().getNbYearExercice(),
                    corporate.get().getRelationEntryDate(),
                    corporate.get().getSeniorityRelation(),
                    corporate.get().getFiablityFinancialStatus(),
                    corporate.get().getEvolutionMarche(),
                    corporate.get().getPositionnementCommerce(),
                    corporate.get().getComportementClient(),
                    corporate.get().getPayementIncident(),
                    corporate.get().getUnpaidPresence(),
                    corporate.get().getEngagementStatus(),
                    corporate.get().getFinancialRentability(),
                    corporate.get().getFondRoulement(),
                    corporate.get().getTauxFondRoulement(),
                    corporate.get().getAutonomieFinanciere(),
                    corporate.get().getLiquiditeGenerale(),
                    corporate.get().getYear(),
                    corporate.get().getClientRequest(),
                    corporate.get().getContractReference(),
                    corporate.get().getEmail(),
                    corporate.get().getTelephone(),
                    corporate.get().getMntSollicite(),
                    corporate.get().getDuree(),
                    corporate.get().getMntSolliEcheance(),
                    corporate.get().getMntInitial(),
                    corporate.get().getCapitalRestantDu(),
                    corporate.get().getMntEncEcheance(),
                    corporate.get().getEndDateEncours(),
                    corporate.get().getStatutDossier(),
                    corporate.get().getRetourAnalyste(),
                    corporate.get().getStartDate(),
                    corporate.get().getEndDate(),
                    corporate.get().getCapitalNominal(),
                    corporate.get().getCapitalImpaye(),

                    currency,branch,financingType, activitySector, juridicalForm,
                    corporate.get().getClientNotation()

            );
            return new ResponseEntity<>(fullCorporateResponseResponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Corporate Found",HttpStatus.NOT_FOUND);
        }
    }
}
