package com.patres.messanger;

import com.patres.messanger.service.JsonToDatabaseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    public static final String PATH_TO_INBOX_FOLDER = "D:\\messages\\inbox";

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner demo(JsonToDatabaseService jsonToDatabaseService) {
        return args -> {
            jsonToDatabaseService.loadJsonDataFromInbox(PATH_TO_INBOX_FOLDER);
        };
    }
}
