package com.esprit.scoringservice.web.service.classes;

import com.esprit.scoringservice.web.model.ClientNotation;
import com.esprit.scoringservice.web.repository.ClientNotationRepository;
import com.esprit.scoringservice.web.service.interfaces.IClientNotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ClientNotationService implements IClientNotationService {
    @Autowired
    ClientNotationRepository clientNotationRepository;

    public ClientNotationService(ClientNotationRepository clientNotationRepository) {
        this.clientNotationRepository = clientNotationRepository;
    }

    @Override
    public ResponseEntity<List<ClientNotation>> findAll() {
        try {
            return new ResponseEntity<>(clientNotationRepository.findAll(), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ClientNotationService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ClientNotation> findById(Long id) {
        try {
            return new ResponseEntity(clientNotationRepository.findById(id).orElse(null), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ClientNotationService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public ResponseEntity<ClientNotation> findClientNotationByScoringContractData_Id(Long id) {
        try {
            return new ResponseEntity(clientNotationRepository.findClientNotationByScoringContractData_Id(id), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ClientNotationService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ClientNotation> add(ClientNotation clientNotation) {
        try {
            return new ResponseEntity(clientNotationRepository.save(clientNotation), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ClientNotationService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ClientNotation> update(ClientNotation clientNotation) {
        try {
            return new ResponseEntity(clientNotationRepository.save(clientNotation), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ClientNotationService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        try {
            if (clientNotationRepository.existsById(id)) {
                clientNotationRepository.deleteById(id);
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
            return new ResponseEntity<>(false, HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ClientNotationService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
