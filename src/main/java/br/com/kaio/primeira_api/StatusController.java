package br.com.kaio.primeira_api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

// os @ são anotações q o spring usa pra saber o que é o que aqui.
@RestController
public class StatusController {
    
    @GetMapping("/api/status")
    public StatusResponse verificarStatus() {
        return new StatusResponse("online", "Spring Boot (Java)", "Kaio");
    }

}
