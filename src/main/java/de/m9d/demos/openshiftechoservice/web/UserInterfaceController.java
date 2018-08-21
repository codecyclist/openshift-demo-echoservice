package de.m9d.demos.openshiftechoservice.web;

import de.m9d.demos.openshiftechoservice.OpenshiftEchoserviceApplication;
import de.m9d.demos.openshiftechoservice.domain.Message;
import de.m9d.demos.openshiftechoservice.service.DeadMailboxService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller("/")
public class UserInterfaceController  {
    private DeadMailboxService deadMailboxService;

    public UserInterfaceController(DeadMailboxService deadMailboxService) {
        this.deadMailboxService = deadMailboxService;
    }

    @GetMapping("/")
    public String index(Message message, Model model) {
        model.addAttribute("InstanceId", OpenshiftEchoserviceApplication.INSTANCE_ID);
        return "index";
    }

    @PostMapping("/")
    public String putMessage(@ModelAttribute("message")  @Valid Message message, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "index";
        }
        deadMailboxService.putMessage(message);

        return "redirect:/";
    }

    @GetMapping(path="/messages")
    public List<Message> getMessages(Model model) {
        model.addAttribute("messages", deadMailboxService.getMessages());
        return deadMailboxService.getMessages();
    }
}
