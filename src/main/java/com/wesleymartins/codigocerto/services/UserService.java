package com.wesleymartins.codigocerto.services;

import com.wesleymartins.codigocerto.entities.User;
import com.wesleymartins.codigocerto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User insert (User user){
        return userRepository.save(user);
    }
}
