package com.esprit.referentielservice.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BranchIntrouvableException extends RuntimeException {
    public BranchIntrouvableException(String s) {
        super(s);
    }
}
