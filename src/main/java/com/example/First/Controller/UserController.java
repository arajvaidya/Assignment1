package com.example.First.Controller;

import com.example.First.Model.UserDetails;
import com.example.First.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/CreateUser")
    public UserDetails createUser(@RequestBody UserDetails user){
        return userService.createUser(user);
    }
    @DeleteMapping("/DeleteUser/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
    }
    @GetMapping("/getAllUsers")
    public List<UserDetails> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/getUser/{id}")
    public UserDetails getUser(@PathVariable("id") int id){
        return userService.getUser(id);
    }
    @PostMapping("/UpdateUser")
    public UserDetails updateUser(@RequestBody UserDetails userDetails){
        return userService.updateUser(userDetails);
    }
}
