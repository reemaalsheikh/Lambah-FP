package com.example.finalproject.Repository;

import com.example.finalproject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<User, Integer> {

    User findUserById (Integer id);

    User findUserByUsername(String username);

}
