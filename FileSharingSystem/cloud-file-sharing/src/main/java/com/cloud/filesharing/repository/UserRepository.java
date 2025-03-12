// src/main/java/com/cloud/filesharing/repository/UserRepository.java
package com.cloud.filesharing.repository;

import com.cloud.filesharing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Placeholder for repository methods
}