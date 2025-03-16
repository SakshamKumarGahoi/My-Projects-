package com.cloud.filesharing.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;

    @SuppressWarnings("unused")
    private String fileName;

    @SuppressWarnings("unused")
    private String fileType;

    @Column(name = "upload_date")
    private Date uploadDate;
    
    @ManyToOne
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    private User user;     

}