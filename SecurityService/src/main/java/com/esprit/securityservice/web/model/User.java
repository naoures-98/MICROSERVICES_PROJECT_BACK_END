package com.esprit.securityservice.web.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userCode;
    private String password;
    private Boolean isLocked;


    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;


    @ManyToOne(fetch = FetchType.EAGER)
    //@JsonBackReference
    //@JoinColumn(name = "financing_nature_id", nullable = false)
    private Group group;

    @OneToOne(mappedBy = "user")
    @JsonBackReference
    private OrganizationUser organizationUser;
}
