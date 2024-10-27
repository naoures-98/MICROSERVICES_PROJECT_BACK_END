package com.esprit.referentielservice.web.dao;

import com.esprit.referentielservice.web.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BranchDao extends JpaRepository<Branch,Long> {
    List <Branch> findAll();
    Optional<Branch> findById(Long id);
    Branch save(Branch branch);

}
