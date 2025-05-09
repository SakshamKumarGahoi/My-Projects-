package com.cloud.filesharing.service;
import com.cloud.filesharing.config.SecurityConfig;
import com.cloud.filesharing.entity.User;
import com.cloud.filesharing.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.cloud.filesharing.repository.*;
import com.cloud.filesharing.repository.UserRepository;
import com.cloud.filesharing.exceptions.UsernameAlreadyExistsException;

public class UserServiceImpl extends UserService{
private final UserRepository  userRepository;
private final FileRepository fileRepository;
private final RoleRepository roleRepository;
private final PasswordEncoder passwordEncoder;
@Autowired
public UserServiceImpl(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       RoleRepository roleRepository,
                       FileRepository fileRepository) {
this.userRepository = userRepository;
this.passwordEncoder = passwordEncoder;
this.roleRepository = roleRepository;
this.fileRepository = fileRepository;
                       }
@Override
public User saveUser(User user) {
    //check for user existence
    if(userRepository.existsByUsername(user.getUsername())){
        throw new UsernameAlreadyExistsException("Username already exists");
    }

    user.setRole(roleRepository.findByName(ERole.USER).orElseThrow(() -> new RuntimeException("Error: User Role is not found.")));
    user.setRole(roleRepository.findByName(Erole.USER).orElseThrow(() -> new RuntimeException("Error: User Role is not found.")));
    //hashing the password
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
}

@Override
public User createAdminUser(User user){
    user.setRole(roleRepository.findByName(ERole.ADMIN).orElseThrow(() -> new RuntimeException("Error: Admin Role is not found.")));
    user.SetRole(roleRepository.findByName(ERole.ADMIN).orElseThrow(() -> new RuntimeException("Error: Admin Role is not found.")));
    //hashing the password
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user); }

}