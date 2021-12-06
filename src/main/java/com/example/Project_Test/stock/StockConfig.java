package com.example.Project_Test.stock;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StockConfig {

    @Bean
    CommandLineRunner commandLineRunnerStock(StockRepository repository){
        return args -> {
            Stock samsung = new Stock(
                    "Samsung",
                    11,
                    1000
            );
            Stock huawei = new Stock(
                    "Huawei",
                    12,
                    2000
            );
            Stock iphone = new Stock(
                    "Iphone",
                    13,
                    3000
            );
            Stock sony = new Stock(
                    "Sony",
                    14,
                    4000
            );
            Stock lg = new Stock(
                    "LG",
                    15,
                    5000
            );
            repository.saveAll(
                    List.of(samsung, huawei, iphone, sony, lg)
            );
        };
    }
}
