package org.petservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/pets")
public class PetController {

    public PetController() {
    }

    @GetMapping("/test")
    public String testMethod() {
        return "copy";
    }
}
