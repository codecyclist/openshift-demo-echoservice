package de.m9d.demos.openshiftechoservice.domain;

import java.time.Instant;

public class Message {
    private Instant created;
    private String message;

    public Message(String message) {
        this.created = Instant.now();
        this.message = message;
    }

    public Instant getCreated() {
        return created;
    }

    public String getMessage() {
        return message;
    }


}
