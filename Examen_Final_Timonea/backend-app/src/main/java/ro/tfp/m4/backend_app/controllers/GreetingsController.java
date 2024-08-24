package ro.tfp.m4.backend_app.controllers;

import ro.tfp.m4.backend_app.entity.greeting;
import ro.tfp.m4.backend_app.service.GreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingsController {

    @Autowired
    private GreetingService greetingService;

    @PostMapping("/add")
    @CrossOrigin
    public ResponseEntity<String> addGreeting(@RequestBody greeting greeting) {
        boolean isCreated = greetingService.createNewGreeting(greeting);
        if (isCreated) {
            return ResponseEntity.ok("Felicitarea a fost adaugata cu succes.");
        } else {
            return ResponseEntity.badRequest().body("Pret invalid. Felicitarea nu a putut fi adaugata.");
        }
    }

    @GetMapping("/getAll")
    @CrossOrigin
    public ResponseEntity<?> getAllGreetings() {
        List<greeting> greetings = greetingService.getAllGreetings();
        if (greetings.isEmpty()) {
            return ResponseEntity.ok("Nu exista felicitari in baza de date.");
        } else {
            return ResponseEntity.ok(greetings);
        }
    }
}