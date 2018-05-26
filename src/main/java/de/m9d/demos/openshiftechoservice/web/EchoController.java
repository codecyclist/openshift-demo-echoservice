package de.m9d.demos.openshiftechoservice.web;

import de.m9d.demos.openshiftechoservice.domain.Message;
import de.m9d.demos.openshiftechoservice.service.DeadMailboxService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EchoController {
    private DeadMailboxService deadMailboxService;

    public EchoController(DeadMailboxService deadMailboxService) {
        this.deadMailboxService = deadMailboxService;
    }

    @RequestMapping("/")
    public String echo() {
        return "It works, too!";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/")
    public void putMessage(@RequestParam("message") String message) {
        deadMailboxService.putMessage(message);
    }

    @RequestMapping(path="/messages")
    public List<Message> getMessages() {
        return deadMailboxService.getMessages();
    }
}
