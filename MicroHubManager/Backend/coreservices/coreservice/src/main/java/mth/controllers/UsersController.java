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

    @PostMapping("signin")
    public Object signIn(@RequestBody Map<String,Object> data){
        return US.signin(data);
    }

    @GetMapping("/uinfo")
    public Object uinfo(@RequestHeader("Token") String token){
        return US.uinfo(token);
    }

    @GetMapping("/profile")
    public Object profile(@RequestHeader("Token")String token){
        return US.getProfile(token);
    }

    @GetMapping("/getallusers/{PAGE}/{SIZE}")
    public Object getAllUsers(@PathVariable("PAGE") int page,@PathVariable("SIZE") int size,@RequestHeader("token")String token){
        return US.getAllUsers(page,size,token);
    }


    @PostMapping("/saveuser")
	 public Object saveUser(@RequestBody Users U,@RequestHeader String Token)
	 {
		 return US.saveUser(U, Token);
	 }
}