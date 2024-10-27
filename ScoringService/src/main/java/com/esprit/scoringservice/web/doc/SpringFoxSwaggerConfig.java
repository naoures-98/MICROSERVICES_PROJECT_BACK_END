package com.esprit.scoringservice.web.doc;

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
        server.setUrl("http://localhost:8091");
        server.setDescription("Development");

        Contact myContact = new Contact();
        myContact.setName("Naoures BEN GHORBEL");
        myContact.setEmail("BENGHORBELNAOURES@gmail.com");

        Info information = new Info()
                .title("SCORING Management System API")
                .version("1.0")
                .description("This API exposes endpoints to manage SCORING SERVICE.")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));
    }
}
