package org.contollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Requests {
    @GetMapping("/")
    public String version(){
        return "<h2>started application</h2>";
    }
}
