package com.example.First.Service;

import com.example.First.Model.UserDetails;
import com.example.First.Repository.UserRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepositry userRepositry;
    public UserService(UserRepositry userRepositry){
        this.userRepositry = userRepositry;
    }
    public List<UserDetails> getAllUsers(){
        return userRepositry.getAllUsers();
    }
    public UserDetails getUser(int id){
        return userRepositry.getUser(id);
    }
    public UserDetails createUser(UserDetails user){
        return userRepositry.createUser(user);
    }
    public void deleteUser(int id){
        userRepositry.deleteUser(id);
    }
    public UserDetails updateUser(UserDetails userDetails){
        return userRepositry.updateUser(userDetails);
    }
}
