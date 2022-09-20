package com.springboot.springorderapp;

import com.springboot.springorderapp.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    // the CommandLineRunner bean will be run once the application context is loaded
    @Bean
    CommandLineRunner initDatabase(CustomerRepository repository) {
        return args -> {
//            log.info("Preloading " + repository.save(new Employee("Nancy", "Luis", "staff")));
//            log.info("Preloading " + repository.save(new Employee("Amy", "Charlie", "manager")));
        };
    }
}
