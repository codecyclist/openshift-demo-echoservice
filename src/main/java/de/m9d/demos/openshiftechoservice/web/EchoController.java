package de.m9d.demos.openshiftechoservice.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    @RequestMapping("/")
    public String echo() {
        return "It works, too!";
    }
}
