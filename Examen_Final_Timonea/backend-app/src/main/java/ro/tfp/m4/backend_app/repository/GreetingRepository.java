package ro.tfp.m4.backend_app.repository;

import ro.tfp.m4.backend_app.entity.greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<greeting, Long> {
}
