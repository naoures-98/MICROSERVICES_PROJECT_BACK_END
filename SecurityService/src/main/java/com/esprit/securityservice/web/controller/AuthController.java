package com.esprit.securityservice.web.controller;

import com.esprit.securityservice.web.dto.AuthRequest;
import com.esprit.securityservice.web.dto.AuthResponse;
import com.esprit.securityservice.web.model.Group;
import com.esprit.securityservice.web.model.User;
import com.esprit.securityservice.web.service.classes.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Security")
//@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    @Autowired
    private AuthService service;

    @Autowired
    private AuthenticationManager authenticationManager;



    @PostMapping("/auth/register")
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        return service.saveUser(user);
    }


    @PostMapping("/auth/token")
    public AuthResponse getToken(@RequestBody AuthRequest authRequest) {
    //public AuthResponse getToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserCode(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            User user = service.findByUserCode(authRequest.getUserCode());
            return new AuthResponse(user,service.generateToken(authRequest.getUserCode()));
            //return service.generateToken(authRequest.getUserCode());

            //return service.generateToken(authRequest);
        } else {
            throw new RuntimeException("invalid access");
        }
    }

    @GetMapping("/auth/validate")
    public String validateToken(@RequestParam("token") String token) {
        service.validateToken(token);
        return "Token is valid";
    }
    @GetMapping("/auth/{id}")
    private ResponseEntity<User> findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping
    private ResponseEntity<List<User>> findAll() {

        return service.findAll();
    }
    @PutMapping("/auth")
    private ResponseEntity<User> update(@RequestBody User user) {
        return service.update(user);
    }
    @DeleteMapping("/auth/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }



    @PostMapping("/auth/logout")
    public ResponseEntity<Map<String, String>> logout(HttpServletRequest request) {
        // Vous pouvez ici ajouter la logique de déconnexion (invalidating token, session, etc.)
        Map<String, String> response = new HashMap<>();
        response.put("message", "Déconnexion réussie.");
        return ResponseEntity.ok(response);
    }


    @GetMapping("/forAdmin")
    @PreAuthorize("hasRole('admin')")
    public String forAdmin(){
        return "This URL is only accessible to Admin";
    }

    @GetMapping("/forCharge")
    @PreAuthorize("hasRole('Chargé Clientele')")
    public String forCharge(){
        return "This URL is only accessible to Chargé clientele";
    }
    @GetMapping("/forJuridiction")
    @PreAuthorize("hasRole('Juridiction')")
    public String forJuridiction(){
        return "This URL is only accessible to Juridiction";
    }
}
