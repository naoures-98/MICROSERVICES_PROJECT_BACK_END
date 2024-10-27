package com.esprit.referentielservice.web.Service.classes;

import com.esprit.referentielservice.web.Repository.CurrencyRepository;
import com.esprit.referentielservice.web.Service.Interfaces.ICurrencyService;
import com.esprit.referentielservice.web.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CurrencyService implements ICurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository ;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public ResponseEntity<List<Currency>> findAll() {
        try {
            return new ResponseEntity<>(currencyRepository.findAll(), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(CurrencyService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Currency> findById(Long id) {
        try {
            return new ResponseEntity(currencyRepository.findById(id).orElse(null), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(CurrencyService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Currency> add(Currency currency) {
        try {
            return new ResponseEntity(currencyRepository.save(currency), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(CurrencyService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Currency> update(Currency currency) {
        try {
            return new ResponseEntity(currencyRepository.save(currency), HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(CurrencyService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        try {
            if (currencyRepository.existsById(id)) {
                currencyRepository.deleteById(id);
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
            return new ResponseEntity<>(false, HttpStatus.OK);
        } catch (Exception exception) {
            Logger.getLogger(CurrencyService.class.getName()).log(Level.WARNING, exception.getMessage());
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
