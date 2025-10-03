package com.example.autotools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutoToolsApplication {

    @org.springframework.context.annotation.Bean
    public org.springframework.boot.CommandLineRunner commandLineRunner(org.springframework.core.env.Environment env) {
        return args -> {
            System.out.println("--- VERIFICANDO PROPRIEDADE ---");
            System.out.println("api.receitaws.url = " + env.getProperty("api.receitaws.url"));
            System.out.println("-----------------------------");
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(AutoToolsApplication.class, args);
    }


}