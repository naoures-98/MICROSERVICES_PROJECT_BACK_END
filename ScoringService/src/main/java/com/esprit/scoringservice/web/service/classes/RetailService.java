package com.esprit.scoringservice.web.service.classes;

import com.esprit.scoringservice.web.client.ActivitySectorClient;
import com.esprit.scoringservice.web.client.BranchClient;
import com.esprit.scoringservice.web.client.CurrencyClient;
import com.esprit.scoringservice.web.client.FinancingTypeClient;
import com.esprit.scoringservice.web.dto.*;
import com.esprit.scoringservice.web.model.Retail;
import com.esprit.scoringservice.web.repository.RetailRepository;
import com.esprit.scoringservice.web.service.interfaces.IRetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class RetailService implements IRetailService {
    @Autowired
    RetailRepository retailRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CurrencyClient currencyClient ;
    @Autowired
    private FinancingTypeClient financingTypeClient ;
    @Autowired
    private BranchClient branchClient ;
    @Autowired
    private ActivitySectorClient activitySectorClient ;

    public RetailService(RetailRepository retailRepository) {
        this.retailRepository = retailRepository;
    }

    @Override
    public ResponseEntity<List<Retail>> findAll() {
        try {
            return new ResponseEntity<>(retailRepository.findAll(), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(RetailService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Retail> findById(Long id) {
        try {
            return new ResponseEntity(retailRepository.findById(id).orElse(null), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(RetailService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Retail> add(Retail retail) {
        try {
            return new ResponseEntity(retailRepository.save(retail), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(RetailService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Retail> update(Retail retail) {
        try {
            return new ResponseEntity(retailRepository.save(retail), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(RetailService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        try {
            if (retailRepository.existsById(id)) {
                retailRepository.deleteById(id);
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
            return new ResponseEntity<>(false, HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(RetailService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public ResponseEntity<?> fetchRetailById(Long id){
        Optional<Retail> retail =  retailRepository.findById(id);
        if(retail.isPresent()){
            Currency currency = restTemplate.getForObject("http://ReferentielService/Referentiel/Currency/" + retail.get().getCurrencyId(), Currency.class);

            RetailResponse retailResponse = new RetailResponse(
                    //retail.get().getId(),
                    retail.get().getCivility(),
                    retail.get().getGender(),
                    retail.get().getFirstName(),
                    retail.get().getLastName(),
                    retail.get().getBirthDate(),
                    retail.get().getAge(),
                    retail.get().getRevenu(),
                    retail.get().getNbrDependents(),
                    retail.get().getFamilySituation(),
                    retail.get().getProfession(),
                    retail.get().getEmployementStatus(),
                    currency
            );
            return new ResponseEntity<>(retailResponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Retail Found",HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public ResponseEntity<?> findRetailWithCurrency(Long id){
        Optional<Retail> retail =  retailRepository.findById(id);
        if(retail.isPresent()){
            Currency currency = currencyClient.findAllScoringContractDataByCurrency(retail.get().getCurrencyId());
            System.out.println("retail.get().getCurrencyId() = "+ retail.get().getCurrencyId());
            RetailResponse retailResponse = new RetailResponse(
                    //retail.get().getId(),
                    retail.get().getCivility(),
                    retail.get().getGender(),
                    retail.get().getFirstName(),
                    retail.get().getLastName(),
                    retail.get().getBirthDate(),
                    retail.get().getAge(),
                    retail.get().getRevenu(),
                    retail.get().getNbrDependents(),
                    retail.get().getFamilySituation(),
                    retail.get().getProfession(),
                    retail.get().getEmployementStatus(),
                    currency

            );
            return new ResponseEntity<>(retailResponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Retail Found",HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public ResponseEntity<?> findRetailWithAllRelations(Long id) {
        Optional<Retail> retail =  retailRepository.findById(id);
        if(retail.isPresent()){
            Currency currency = currencyClient.findAllScoringContractDataByCurrency(retail.get().getCurrencyId());
            Branch branch = branchClient.findAllScoringContractDataByBranch(retail.get().getBranchId());
            System.out.println("getFinancingTypeId = "+ retail.get().getFinancingTypeId());
            FinancingType financingType = financingTypeClient.findAllScoringContractDataByFinancingType(retail.get().getFinancingTypeId());
            ActivitySector activitySector = activitySectorClient.findAllScoringContractDataByActivitySector(retail.get().getActivitySectorId());

            FullRetailResponse fullRetailResponse = new FullRetailResponse(
                    //retail.get().getId(),
                    retail.get().getCivility(),
                    retail.get().getGender(),
                    retail.get().getFirstName(),
                    retail.get().getLastName(),
                    retail.get().getBirthDate(),
                    retail.get().getYear(),
                    retail.get().getClientRequest(),
                    retail.get().getContractReference(),
                    retail.get().getEmail(),
                    retail.get().getTelephone(),

                    retail.get().getMntSollicite(),
                    retail.get().getDuree(),
                    retail.get().getMntSolliEcheance(),
                    retail.get().getMntInitial(),
                    retail.get().getCapitalRestantDu(),
                    retail.get().getMntEncEcheance(),
                    retail.get().getEndDateEncours(),
                    retail.get().getStatutDossier(),
                    retail.get().getRetourAnalyste(),
                    retail.get().getStartDate(),
                    retail.get().getEndDate(),
                    retail.get().getCapitalNominal(),
                    retail.get().getCapitalImpaye(),
                    retail.get().getAge(),
                    retail.get().getRevenu(),
                    retail.get().getNbrDependents(),
                    retail.get().getEmployerSize(),
                    activitySector,
                    retail.get().getDeptRatio(),
                    retail.get().getRelationEntryDate(),
                    retail.get().getSeniorityRelation(),
                    retail.get().getEmployementEntryDate(),
                    retail.get().getNbYearExperience(),
                    retail.get().getUnpaidPresence(),
                    retail.get().getPayementIncident(),
                    retail.get().getEcheance(),
                    retail.get().getFamilySituation(),
                    retail.get().getProfession(),
                    retail.get().getEmployementStatus(),
                    currency,
                    branch,financingType,
                    retail.get().getClientNotation()

            );
            return new ResponseEntity<>(fullRetailResponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Retail Found",HttpStatus.NOT_FOUND);
        }
    }
}
