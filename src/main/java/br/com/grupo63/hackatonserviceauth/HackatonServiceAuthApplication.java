package br.com.grupo63.hackatonserviceauth;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(title = "${info.name}", description = "${info.description}", version = "${info.version}"),
        servers ={
                @Server(url = "${server.servlet.context-path:}", description = "Current URL"),
                @Server(url = "localhost:${server.port:8080}${server.servlet.context-path:}", description = "Localhost"),
                @Server(url = "${app.docs-api-url:(no value)}${server.servlet.context-path:}", description = "Custom URL from env")
        })
@SpringBootApplication
public class HackatonServiceAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(HackatonServiceAuthApplication.class, args);
    }

}
