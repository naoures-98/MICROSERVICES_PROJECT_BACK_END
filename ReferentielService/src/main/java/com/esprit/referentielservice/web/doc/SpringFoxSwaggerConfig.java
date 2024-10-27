package com.esprit.referentielservice.web.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class SpringFoxSwaggerConfig {
    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:9090");
        server.setDescription("Development");

        Contact myContact = new Contact();
        myContact.setName("Naoures BEN GHORBEL");
        myContact.setEmail("BENGHORBELNAOURES.com");

        Info information = new Info()
                .title("Referentiel Management System API")
                .version("1.0")
                .description("This API exposes endpoints to manage Referentiel.")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));
    }
}
