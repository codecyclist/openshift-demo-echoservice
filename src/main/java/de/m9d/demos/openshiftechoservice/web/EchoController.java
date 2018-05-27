package de.m9d.demos.openshiftechoservice.web;

import de.m9d.demos.openshiftechoservice.domain.Message;
import de.m9d.demos.openshiftechoservice.service.DeadMailboxService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController("/api/v1/messages")
public class EchoController {
    private DeadMailboxService deadMailboxService;

    public EchoController(DeadMailboxService deadMailboxService) {
        this.deadMailboxService = deadMailboxService;
    }

    @PostMapping()
    public RedirectView putMessage(@RequestParam("message") String message) {
        deadMailboxService.putMessage(message);
        return new RedirectView("/");
    }

    @GetMapping()
    public List<Message> getMessages() {
        return deadMailboxService.getMessages();
    }
}
