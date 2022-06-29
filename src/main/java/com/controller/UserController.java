package com.controller;

import com.domain.User;
import com.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceimpl;

    @PostMapping("/saveUser")
    public ResponseEntity<User> saveUserData(@Validated @RequestBody User usr){
        return userServiceimpl.save(usr);

    }

    @GetMapping("/getUsers")
    public List<User> showDetails(){
        return userServiceimpl.getAllUser();
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@Validated @RequestBody User users, @PathVariable("id") Long id){
        return userServiceimpl.updateUserProfilesById(users,id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id){
        try {
            userServiceimpl.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/user/{id}")
    public Optional<User> filterUserDetails(@PathVariable("id") Long id){

        Optional<User> user = userServiceimpl.findByUserFilter(id);
        return user;

    }

}
