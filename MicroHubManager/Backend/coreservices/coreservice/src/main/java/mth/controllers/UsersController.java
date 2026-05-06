package mth.controllers;

import mth.repository.UsersRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import mth.models.Users;
import mth.service.UsersService;

import java.util.List;
import java.util.Map;
@CrossOrigin("http://localhost:5174")
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


    public Object signIn(@RequestBody Map<String,Object> data){
        return US.signin(data);
    }
}