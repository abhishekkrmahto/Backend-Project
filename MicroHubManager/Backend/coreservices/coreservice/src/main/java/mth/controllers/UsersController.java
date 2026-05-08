package mth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import mth.models.Users;
import mth.service.UsersService;

@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    UsersService US;

    @PostMapping("/signup")
    public Object signup(@RequestBody Users U) {
        Users u = new Users();
        u = U;
        return US.signup(u);
    }
}