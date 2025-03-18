package com.cloud.filesharing.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false,unique = true)
    private String name;
    
    @Column(nullable = false)
    private String type;
    
    @Column(nullable = false)
    private String size;

    @Column(nullable = false)
    private Date uploadDate;
    
    @ManyToOne
    @JoinColumn(name = "uploaded_by" , nullable = false)
    private User uploadedBy;
    
    @ManyToOne
    @JoinTable(
        name = "file_share",
        joinColumns = @JoinColumn(name = "file_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> sharedWith;

    @ManyToMany
    @JoinTable(
        name = "share",
        joinColumns = @JoinColumn(name = "file_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
        ) 
    private List<Share> shares;
}