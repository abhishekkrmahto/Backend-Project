package mth.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import mth.models.Users;
import mth.repository.RoleRepository;
import mth.repository.UsersRespository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@Service
public class UsersService {
    @Autowired
    UsersRespository UR;

    @Autowired
    RoleRepository RR;

    @Autowired
    JwtService JWT;

    public Object signup(Users U) {
        Map<String, Object> response = new HashMap<>();
        try {
            Object id = UR.checkByEmail(U.getEmail());
            if (id != null) {
                response.put("code", 501);
                response.put("message", "Email ID already registered");
            } else {
                U.setRole(1L); // Setting default role to the new user
                U.setStatus(1); // Make the status of the user as active

                UR.save(U); // Insert into the database table (users)✅

                response.put("code", 200);
                response.put("message", "User account has been created.");
            }
        } catch (Exception e) {
            response.put("code", 500);
            response.put("message", e.getMessage());
        }
        return response;
    }

    public Object signin(Map<String, Object> data) {
        Map<String, Object> response = new HashMap<>();
        try {
            Object role = UR.validateCredentials(data.get("username").toString(), data.get("password").toString());
            Users user = (Users) UR.findByEmail(data.get("username").toString());
            if (role != null) {
                response.put("code", 200);
                response.put("jwt", JWT.generateJWT(data.get("username"), role,user.getId()));
            } else {
                response.put("code", 404);
                response.put("message:- ", "Invalid creds!!");
            }
        } catch (Exception e) {
            response.put("code", 500);
            response.put("message:- ", e.getMessage());
        }
        return response;
    }

    public Object uinfo(String token) {
        Map<String, Object> response = new HashMap<>();
        try {
            Map<String, Object> payload = JWT.validateJWT(token);
            String email = (String) payload.get("username");
            Users U = (Users) UR.findByEmail(email);

            List<Object> menuList = UR.getMenus(Long.valueOf(U.getRole()));

            response.put("code", 200);
            response.put("fullname", U.getFullname());
            response.put("menuList", menuList);
        } catch (Exception e) {
            response.put("code", 500);
            response.put("message", e.getMessage());
        }
        return response;
    }

    public Object getProfile(String token) {
        Map<String, Object> response = new HashMap<>();
        try {
            Map<String, Object> payload = JWT.validateJWT(token);
            String email = (String) payload.get("username");
            Object user = UR.profileByEmail(email);

            response.put("code", 200);
            response.put("user", user);
        } catch (Exception e) {
            response.put("code", 500);
            response.put("message", e.getMessage());
        }
        return response;
    }

    public Object getAllUsers(int page, int size, String token) {
        Map<String, Object> response = new HashMap<>();
        try {
            JWT.validateJWT(token);
            Pageable pageable = PageRequest.of(Math.max(page - 1, 0), size); // for pagination
            Page<Users> users = UR.findAll(pageable);

            response.put("code", 200);
            response.put("page", page);
            response.put("size", size);
            response.put("totalpages", users.getTotalPages());
            response.put("users", users.getContent());

        } catch (Exception e) {
            response.put("message", e.getMessage());
        }

        return response;
    }

    public Object saveUser(Users U, String token) {
        Map<String, Object> response = new HashMap<>();
        try {
            JWT.validateJWT(token);
            Object id = UR.checkByEmail(U.getEmail()); // check already email exists or !
            if (id != null)
                throw new Exception("Email ID already registered");
            UR.save(U); // else add
            response.put("code", 200);
            response.put("message", "new user account has been created .");

        } catch (Exception e) {
            response.put("code", 500);
            response.put("message", e.getMessage());
        }
        return response;
    }

    public Object deleteUser(String token, Long id){
        Map<String, Object> response = new HashMap<>();
        try{
            JWT.validateJWT(token);
            UR.deleteById(id);
            response.put("code",200);
            response.put("message","User deleted");
        }catch (Exception e){
            response.put("code", 500);
            response.put("message", e.getMessage());
        }
        return response;
    }



    public Object getUserById(Long id, String token)
    {
        Map<String, Object> response = new HashMap<>();
        try
        {
            JWT.validateJWT(token); //Authorization
            Users user = UR.findById(id).get();

            response.put("code", 200);
            response.put("user", user);
        }catch(Exception e)
        {
            response.put("code", 500);
            response.put("message", e.getMessage());
        }
        return response;
    }


    public Object searchUser(String key, String token)
    {
        Map<String, Object> response = new HashMap<>();
        try
        {
            JWT.validateJWT(token);
            List<Users> users = UR.searchUser(key);
            response.put("code", 200);
            response.put("users", users);
        }catch(Exception e)
        {
            response.put("code", 500);
            response.put("message", e.getMessage());
        }
        return response;
    }

}
