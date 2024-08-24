package ro.tfp.m4.backend_app.service;

import ro.tfp.m4.backend_app.entity.greeting;
import ro.tfp.m4.backend_app.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    public boolean createNewGreeting(greeting greeting) {
        if (greeting.getPrice() <= 0) {
            return false;
        }
        greetingRepository.save(greeting);
        return true;
    }

    public List<greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }
}