package com.user.services;



import com.user.entity.User;

public interface UserServices {
    public User getUser(Long id);

    public User saveUser(User user);

    public void login(String username, String password);
    
}
