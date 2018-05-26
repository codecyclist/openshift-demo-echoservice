package de.m9d.demos.openshiftechoservice.service;

import de.m9d.demos.openshiftechoservice.domain.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DeadMailboxService {
    private List<Message> messages;

    public DeadMailboxService() {
        messages = new ArrayList<>();
    }

    public void putMessage(String message) {
        messages.add(new Message(message));
    }

    public List<Message> getMessages() {
        return Collections.unmodifiableList(messages);
    }
}
