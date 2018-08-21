package de.m9d.demos.openshiftechoservice.domain;

import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;


public class Message {
    private Instant created;

    @NotNull(message="{validation.newMessage.empty.message}")
    @NotEmpty(message="{validation_newMessage_empty_message}")
    @Length(min=4, message = "{validation_newMessage_tooShort_message}")
    private String content;

    public Message(String content) {
        this.created = Instant.now();
        this.content = content;
    }

    public Message() {
        this.created = Instant.now();
    }


    public Instant getCreated() {
        return created;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
