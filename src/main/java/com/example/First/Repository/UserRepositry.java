package com.example.First.Repository;

import com.example.First.Model.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserRepositry {
    private List<UserDetails> users;
    UserDetails user1 = new UserDetails(1,"ammy","amitesh","rajvaidya", "12345");
    UserDetails user2 = new UserDetails(2,"grammy","peterson", "kevin", "12345");
    public UserRepositry(){
        users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
    }

    public List<UserDetails> getAllUsers(){
        return users;
    }
    public UserDetails getUser(int id){
        UserDetails user = users.stream()
                .filter(customer -> id == customer.getUserId())
                .findAny()
                .orElse(null);
        return user;
    }
    public UserDetails createUser(UserDetails user){
        if(users.stream().anyMatch(x-> x.getUserId() == user.getUserId())){
            return null;
        }
        else{
            users.add(user);
            return user;
        }
    }
    public void deleteUser(int id){
        users.removeIf( x-> x.getUserId() == id);
    }
    public UserDetails updateUser(UserDetails userDetails) {
        UserDetails us = users.stream()
                .filter(x -> x.getUserId() == userDetails.getUserId())
                .findFirst()
                .orElse(null);
        us.setFirstName(userDetails.getFirstName());
        us.setLastName(userDetails.getLastName());
        us.setUserName(userDetails.getUserName());
        us.setPassword(userDetails.getPassword());
        return userDetails;
    }
}
