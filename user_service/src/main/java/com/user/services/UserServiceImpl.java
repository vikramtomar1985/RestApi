package com.user.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.user.entity.Contact;
import com.user.entity.User;
import com.user.repository.UserRepo;

@Service
public class UserServiceImpl implements UserServices {

  /**
   *
   */
  @Autowired(required=true)
  private UserRepo userRepo;

  List<Contact> contactList = List.of(
      new Contact(101L, "Deepak.Yadav@gmail.com", "Deepak Yadav",100L),
      new Contact(102L, "Kalyan.Yadav@gmail.com", "Kalyan Yadav",1002L),
      new Contact(103L, "Vijay.Yadav@gmail.com", "Vijay Yadav",1003L)
    );

    // user data
    List<User> list = List.of(
      new User(100L, "Deepak Yadav", "8762374629"),
      new User(1002L, "Kalyan Yadav", "8762374625"),
      new User(1003L, "Vijay Yadav", "8762374624")
    );

    

    @Override
    public User getUser(Long id) {      
        return this.list.stream().filter(user -> user.getUserId().equals(id)).findAny().orElse(null);
    }



    @Override
    public User saveUser(User user) {     
    return userRepo.save(user);
    }



    /* (non-Javadoc)
     * @see com.user.services.UserServices#login(java.lang.String, java.lang.String)
     */
    @Override
    public void login(String username, String password) {
         
      
    }
    
}
