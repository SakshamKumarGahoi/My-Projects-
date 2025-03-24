package com.cloud.filesharing.service;
import com.cloud.filesharing.entity.User;
import com.cloud.filesharing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }
    
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long userId){
        return userRepository.findById(userId).orElse(null);
    }

    public User updateUser(User user){
        if(userRepository.existsById(user.getId())){
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long userId){
    try {
        userRepository.deleteById(userId);
    } catch (Exception e) {
        throw new RuntimeException("Error deleting user with id: " + userId, e);
    }
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

}
