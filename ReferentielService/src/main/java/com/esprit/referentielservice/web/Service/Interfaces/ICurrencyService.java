package com.esprit.referentielservice.web.Service.Interfaces;

import com.esprit.referentielservice.web.model.Currency;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICurrencyService {
    ResponseEntity<List<Currency>> findAll();
    ResponseEntity<Currency> findById(Long id);
    ResponseEntity<Currency> add(Currency currency);
    ResponseEntity<Currency> update(Currency currency);
    ResponseEntity<Boolean> delete(Long id);

}
