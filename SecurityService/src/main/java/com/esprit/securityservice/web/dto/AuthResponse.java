package com.esprit.securityservice.web.dto;

import com.esprit.securityservice.web.model.User;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AuthResponse { //jwtRequest
    private User user ;
    private String jwtToken;
}
