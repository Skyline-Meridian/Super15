package com.super15.quiz.repository;

import com.super15.quiz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository {

 public User findByName(String name);

}
