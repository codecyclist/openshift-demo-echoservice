package de.m9d.demos.openshiftechoservice.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
public class Message {
    private Instant created = Instant.now();

    @NotNull(message="{validation.newMessage.empty.message}")
    @NotEmpty(message="{validation_newMessage_empty_message}")
    @Length(min=4, message = "{validation_newMessage_tooShort_message}")
    private String content;

    public Message(String content) {
        this.content = content;
    }
}
