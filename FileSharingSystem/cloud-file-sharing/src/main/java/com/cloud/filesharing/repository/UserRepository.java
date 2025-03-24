// src/main/java/com/cloud/filesharing/repository/UserRepository.java
package com.cloud.filesharing.repository;

import com.cloud.filesharing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Query for basic commands

    @Query("SELECT u FROM User u WHERE u.username = :username")
    User findByUsername(@Param("username") String username);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findbyEmail(@Param("email") String email);

    boolean existsByUsername(String username);

}