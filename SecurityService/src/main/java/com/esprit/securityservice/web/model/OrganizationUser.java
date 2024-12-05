package com.esprit.securityservice.web.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class OrganizationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String matricule;
    private String userName;
    private String userFunction;
    private String email ;
    private String telephone ;

    @OneToOne
    @JsonManagedReference
    private User user;
}
