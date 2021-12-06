package com.example.Project_Test.user_authentication;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository repository) {
        return args -> {
            User admin = new User(
                    "admin",
                    "$2a$12$T81bXf.eHQCf4iEUVmecve8mucU9ttZu.X2F5U6jKejMOtKJGNlFW",
                    "admin@mail.com",
                    "ADMIN");
            User user1 = new User(
                    "User1",
                    "$2a$12$qQYYtPC4HXjYW.dRnwWko.EjZawEFnJYr9OlYo/GPfbTvgXfhzF36",
                    "User1@mail.com",
                    "USER");

            repository.saveAll(
                    List.of(admin, user1));
        };
    }

}
