package de.m9d.demos.openshiftechoservice.web;

import de.m9d.demos.openshiftechoservice.domain.Message;
import de.m9d.demos.openshiftechoservice.service.DeadMailboxService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController("/api/v1/messages")
public class ApiController {
    private DeadMailboxService deadMailboxService;

    public ApiController(DeadMailboxService deadMailboxService) {
        this.deadMailboxService = deadMailboxService;
    }

    @PostMapping()
    public String putMessage(@ModelAttribute("message")  @Valid Message message, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        deadMailboxService.putMessage(message);

        return "redirect:/";
    }

    @GetMapping()
    public List<Message> getMessages() {
        return deadMailboxService.getMessages();
    }
}
