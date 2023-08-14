package com.asbika.secproject;

import com.asbika.secproject.auth.AuthenticationService;
import com.asbika.secproject.auth.RegisterRequest;
import com.asbika.secproject.user.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;

import static com.asbika.secproject.user.Role.ADMIN;
import static com.asbika.secproject.user.Role.MANAGER;

@SpringBootApplication
public class SecProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService service
    ){
        return args ->{
            var admin = RegisterRequest.builder()
                    .firstname("Admin")
                    .lastname("Admin")
                    .email("admin@gmail.com")
                    .password("password")
                    .role(ADMIN)
                    .build();
            System.out.println("admin token:   "+service.register(admin).getToken());
            var manager = RegisterRequest.builder()
                    .firstname("Manager")
                    .lastname("Manager")
                    .email("manager@gmail.com")
                    .password("password")
                    .role(MANAGER)
                    .build();
            System.out.println("manager token:   "+service.register(manager).getToken());
        };
    }
}
