package com.example.soham.usersignup.dao;

import com.example.soham.usersignup.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

    User getUserByEmail(String email);
}
