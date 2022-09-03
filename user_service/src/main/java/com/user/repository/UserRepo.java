package com.user.repository;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.entity.User;

@Repository
@Qualifier("UserRepo")
public interface UserRepo extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);
    Optional<User> findByUserNameOrEmail(String username, String email);
    Optional<User> findByUserName(String username);
    Boolean existsByUserName(String username);
    Boolean existsByEmail(String email);
    
}
