package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.constants.Status;
import com.user.entity.User;
import com.user.repository.UserRepo;
import com.user.services.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {
    

    @Autowired
    private UserServices userServices;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId){
        return userServices.getUser(userId);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User users){
        return userServices.saveUser(users);
    }

    @RequestMapping("/login1")
    public void login(@RequestParam("username") String username,
           @RequestParam("password") String password) {

        // The UserServiceImpl is already injected and you can use it
        userServices.login(username, password);

    }

    @PostMapping("/login")
    public Status userLogin(@RequestBody User user){        
        System.out.println("Current User Name:  "+ user.getName());
        System.out.println(userRepo.findByUserName(user.getUserName()));

        if(userRepo.findByUserName(user.getUserName()).isPresent()){
            userServices.login(user.getUserName(), user.getPassword());
            return Status.SUCCESS;
        }
        
        return Status.FAILURE;
    }

    @PostMapping("/register")
    public Status registerUser( @RequestBody User newUser) {
        List<User> users = userRepo.findAll();
        System.out.println("New user: " + newUser.toString());
        for (User user : users) {
            System.out.println("Registered user: " + newUser.toString());
            if (user.equals(newUser)) {
                System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }
        userRepo.save(newUser);
        return Status.SUCCESS;
    }

    @PostMapping("/logout")
    public Status logUserOut(@RequestBody User user) {
        List<User> users = userRepo.findAll();
        
        for (User other : users) {
            System.out.println("User Name:  "+ user.getName());
            if (other.equals(user)) {
                user.setLoggedIn(false);
                userRepo.save(user);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }

    @PostMapping("/delete")
    public Status deleteAll() {       
        
        userRepo.deleteAll();
        return Status.SUCCESS;
    }
}
