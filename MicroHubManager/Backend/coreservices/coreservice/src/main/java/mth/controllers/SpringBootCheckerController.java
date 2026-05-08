package mth.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootCheckerController {
    @GetMapping("/check")
    public String checkSpringBootApp(){
        return "APP IS RUNNING FINE !! ✅";
    }
}
