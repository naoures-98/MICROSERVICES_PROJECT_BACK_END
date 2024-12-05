package com.esprit.securityservice.web.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AuthRequest { //jwtRequest
    private String userCode;
    private String password;
}
