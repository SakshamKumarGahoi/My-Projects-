package com.cloud.filesharing.controller;

import com.cloud.filesharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.cloud.filesharing.entity.User;

@RestController
@RequestMapping("/api/Users")
public class UserController {

     @Autowired
     private UserService userService;
     @GetMapping
     public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
     }
     @PostMapping
     public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
     }
     @PutMapping("/{id}")
     public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);
     }
     @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteUser(@PathVariable Long id){
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
