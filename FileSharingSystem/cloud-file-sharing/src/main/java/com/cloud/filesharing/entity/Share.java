package com.cloud.filesharing.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.cglib.core.Local;

import java.io.Serializable;
import java.util.*;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "share")
@IdClass(Share.PK.class)
@Data
public class Share {

    @EmbeddedId
    private Share.PK pk;    

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "file_id", insertable = false, updatable = false)
    private File file;

    @Column(name = "shared_on", nullable = false)
    private LocalDate sharedOn;
    
    @Column(name = "message", columnDefinition = "TEXT")
    private String message;

    @IdClass(Share.PK.class)
    public static class PK implements Serializable {
        @Id
        @Column(name = "user_id")
        private Long userId;

        @Id
        @Column(name = "file_id")   
        private Long fileId;

        //NO ARG CONSTRUCTOR
        public PK() {
        }

        public PK(Long userId, Long fileId) {
            this.userId = userId;
            this.fileId = fileId;
        }

        //GETTERS AND SETTERS

        public Long getUserId() {
            return userId;
        }
        public void setUserId(Long userId) {
            this.userId = userId;
        }
        public Long getFileId() {
            return fileId;
        }
        public void setFileId(Long fileId) {
            this.fileId = fileId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PK pk = (PK) o;
            return Objects.equals(userId, pk.userId) && Objects.equals(fileId , pk.fileId);
        }
        @Override
        public int hashCode() {
            return Objects.hash(userId, fileId);
        }
    }
}
