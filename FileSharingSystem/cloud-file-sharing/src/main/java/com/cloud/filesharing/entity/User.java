package com.cloud.filesharing.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;

import jakarta.persistence.*;
@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable = false , unique = true)
private String username;
@Column(nullable = false , unique = true)    
private String email;
private String password;

@Column( updatable = false ,name = "created_at")
    private Date createdAt;
@Column(name = "updated_at")
    private Date updatedAt;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<File> files;   

    // GETTERS AND SETTERS

public Long getId(){ return id; }
public void setId(Long id){ this.id = id; }

public String getUsername(){ return username ;}
public void setUsername(String username){ this.username = username;}

public String getEmail(){ return email; }
public void setEmail(String email){ this.email = email; }

public String getPassword(){ return password; }
public void setPassword(String password){ this.password = password; }

public Date getCreatedAt(){ return createdAt; }
public void setCreatedAt(Date createdAt){ this.createdAt = createdAt; }

public Date getUpdatedAt(){ return updatedAt; }
public void setUpdatedAt(Date updatedAt){ this.updatedAt = updatedAt; }

public List<File> getFiles(){ return files; }   
public void setFiles(List<File> files){ this.files = files; }
}
