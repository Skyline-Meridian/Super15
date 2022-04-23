package com.super15.quiz.repository;

import com.super15.quiz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

 public User findByUserName(String name);

}
