package de.m9d.demos.openshiftechoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class OpenshiftEchoserviceApplication {
    public static final UUID INSTANCE_ID = UUID.randomUUID();

    public static void main(String[] args) {
        SpringApplication.run(OpenshiftEchoserviceApplication.class, args);
    }
}
