package com.esprit.gatewayservice.filter;

import com.esprit.gatewayservice.util.JwtUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import org.springframework.http.server.reactive.ServerHttpRequest;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory <AuthenticationFilter.Config> {

    @Autowired
    private RouteValidator validator;

    //    @Autowired
//    private RestTemplate template;
    @Autowired
    private JwtUtil jwtUtil;

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            if (validator.isSecured.test((ServerHttpRequest) exchange.getRequest())) {
                //header contains token or not
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("missing authorization header");
                }

                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7);
                    System.out.println("authHeader = "+authHeader);
                }
                try {
                    System.out.println("ligne 44");
                    String jwtToken = null ;
                    // On suppose que authHeader contient un JSON, on le parse pour extraire jwtToken
                    try {
                        ObjectMapper objectMapper = new ObjectMapper();
                        JsonNode jsonNode = objectMapper.readTree(authHeader);  // Analyser le JSON
                        // Extraire le jeton JWT du champ "jwtToken"
                        jwtToken = jsonNode.path("jwtToken").asText();
                    }catch(Exception e ){
                        jwtToken = authHeader;
                    }

                    //String jwtToken = authHeader; // `authHeader` est déjà le jeton JWT, sans besoin de le parser

                    System.out.println("ligne 49 jwtToken = "+ jwtToken);
                    if (jwtToken.isEmpty()) {
                        throw new RuntimeException("JWT token not found in authorization header");
                    }
                    System.out.println("jwtToken = " + jwtToken);
                    System.out.println("jwtUtil.validateToken(authHeader);");
//                    //REST call to AUTH service
//                    template.getForObject("http://IDENTITY-SERVICE//validate?token" + authHeader, String.class);
                    jwtUtil.validateToken(jwtToken);

                } catch (Exception e) {
                    System.out.println("invalid access...!");
                    throw new RuntimeException("un authorized access to application");
                }
            }
            return chain.filter(exchange);
        });
    }

    public static class Config {

    }
}
