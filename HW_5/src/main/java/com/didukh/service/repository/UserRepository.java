package com.didukh.service.repository;

import com.didukh.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);

    List<User> findAll();


    boolean existsByEmail(String email);
}
