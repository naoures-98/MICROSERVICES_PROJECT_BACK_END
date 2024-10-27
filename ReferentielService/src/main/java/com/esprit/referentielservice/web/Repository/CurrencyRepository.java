package com.esprit.referentielservice.web.Repository;

import com.esprit.referentielservice.web.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    //List<Currency> findAllBy(Long id);
}
