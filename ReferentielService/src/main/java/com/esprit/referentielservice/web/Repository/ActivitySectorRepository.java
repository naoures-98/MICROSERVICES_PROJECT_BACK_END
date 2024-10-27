package com.esprit.referentielservice.web.Repository;

import com.esprit.referentielservice.web.model.ActivitySector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivitySectorRepository extends JpaRepository<ActivitySector, Long>  {
}
