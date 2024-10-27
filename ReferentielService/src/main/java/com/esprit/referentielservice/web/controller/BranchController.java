package com.esprit.referentielservice.web.controller;

import com.esprit.referentielservice.web.dao.BranchDao;
import com.esprit.referentielservice.web.exceptions.BranchIntrouvableException;
import com.esprit.referentielservice.web.model.Branch;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/Referentiel/Branchs")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8222"})

public class BranchController {
    @Autowired
    private final BranchDao branchDao;
    public BranchController(BranchDao branchDao) {
        this.branchDao = branchDao;
    }
    @Tag(name = "get", description = "GET methods of BRANCH APIs")
    @RequestMapping(method = RequestMethod.GET)
    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8222"}, methods = {RequestMethod.GET})
    public MappingJacksonValue listeAgences() {

        Iterable<Branch> branchs = branchDao.findAll();
        for(Branch branch : branchs)
            System.out.println(">>>>>>"+branch.getName());

        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("id");

        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

        MappingJacksonValue branchsFiltres = new MappingJacksonValue(branchs);

        branchsFiltres.setFilters(listDeNosFiltres);

        return branchsFiltres;
    }
//    @GetMapping("/Branchs")
//    public List<Branch> getBranchs(){
//        return branchDao.findAll();
//    }
@ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(mediaType = "application/json",
                schema = @Schema(implementation = Branch.class)) }),
        @ApiResponse(responseCode = "404", description = "Branch not found",
                content = @Content) })
    @GetMapping("/{id}")
@CrossOrigin(origins =  {"http://localhost:4200", "http://localhost:8222"}, methods = {RequestMethod.GET})
    public Optional<Branch> getBranchById(
            @Parameter(description = "ID of Branch to be retrieved",
        required = true) @PathVariable Long id){
        Optional<Branch> branch= branchDao.findById(id);
        System.out.println(">>>>>>> branch "+ branch.isEmpty());
        if(branch.isEmpty() )
            throw new BranchIntrouvableException("Agence avec l'id "+id+" est introuvable ");
        return branch;
    }
    @DeleteMapping ("/{id}")
    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8222"}, methods = {RequestMethod.DELETE})
    public void deleteBranch(@PathVariable Long id){
        branchDao.deleteById(id);
    }
    @PutMapping
    @CrossOrigin(origins =  {"http://localhost:4200", "http://localhost:8222"}, methods = {RequestMethod.PUT})
    public void updateBranch(@RequestBody Branch branch){
        branchDao.save(branch);
    }
    @PostMapping
    @CrossOrigin(origins =  {"http://localhost:4200", "http://localhost:8222"}, methods = {RequestMethod.POST})
    public ResponseEntity<Branch> addBranch(@Valid @RequestBody Branch branch){
        Branch branchAdded =branchDao.save(branch);
        if(Objects.isNull(branchAdded))
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(branchAdded.getId())
                .toUri();
        return  ResponseEntity.created(location).build();
    }
}
