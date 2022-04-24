package com.super15.quiz.securityConfig;

import com.super15.quiz.enums.Role;
import com.super15.quiz.model.User;
import com.super15.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class IntializeUser {

    @Autowired
    UserRepository userRepository;

    @PostConstruct
    private void postConstruct() {
        List<User> userList = (List<User>) userRepository.findAll();
        if (userList != null && userList.isEmpty()) {
            User admin = new User();
            admin.setEmail("abc@gmail.com");
            admin.setUserName("admin");
            admin.setPassword("12345");
            admin.setRole(Role.ADMIN);
            admin.setMobileNumber("9999999999");
            userRepository.save(admin);
        }
    }
}
