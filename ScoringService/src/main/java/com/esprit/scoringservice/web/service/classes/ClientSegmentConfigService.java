package com.esprit.scoringservice.web.service.classes;

import com.esprit.scoringservice.web.model.ClientSegmentConfig;
import com.esprit.scoringservice.web.repository.ClientSegmentConfigRepository;
import com.esprit.scoringservice.web.service.interfaces.IClientSegmentConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ClientSegmentConfigService implements IClientSegmentConfigService {
    @Autowired
    ClientSegmentConfigRepository clientSegmentConfigRepository;

    public ClientSegmentConfigService(ClientSegmentConfigRepository clientSegmentConfigRepository) {
        this.clientSegmentConfigRepository = clientSegmentConfigRepository;
    }

    @Override
    public ResponseEntity<List<ClientSegmentConfig>> findAll() {
        try {
            return new ResponseEntity<>(clientSegmentConfigRepository.findAll(), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ClientSegmentConfigService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ClientSegmentConfig> findById(Long id) {
        try {
            return new ResponseEntity(clientSegmentConfigRepository.findById(id).orElse(null), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ClientSegmentConfigService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ClientSegmentConfig> findClientSegmentConfigBySegmentCode(String code) {
        try {
            return new ResponseEntity(clientSegmentConfigRepository.findClientSegmentConfigBySegmentCode(code), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ClientSegmentConfigService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ClientSegmentConfig> add(ClientSegmentConfig clientSegmentConfig) {
        try {
            return new ResponseEntity(clientSegmentConfigRepository.save(clientSegmentConfig), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ClientSegmentConfigService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ClientSegmentConfig> update(ClientSegmentConfig clientSegmentConfig) {
        try {
            return new ResponseEntity(clientSegmentConfigRepository.save(clientSegmentConfig), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ClientSegmentConfigService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        try {
            if (clientSegmentConfigRepository.existsById(id)) {
                clientSegmentConfigRepository.deleteById(id);
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
            return new ResponseEntity<>(false, HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(ClientSegmentConfigService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
