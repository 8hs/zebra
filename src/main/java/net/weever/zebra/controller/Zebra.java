package net.weever.zebra.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Zebra {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
}
