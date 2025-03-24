package com.cloud.filesharing.repository;
import com.cloud.filesharing.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.cloud.filesharing.entity.User;
import java.util.List;



public interface FileRepository extends JpaRepository<File,Long> {
    // Query for basic commands

    @Query("SELECT f FROM File f WHERE f.uploader = :uploader")
    List<File> findByUploadedBy(@Param("uploader") User uploader);

 // Query to find files shared with specific user
    @Query("SELECT f FROM File f WHERE :user IN f.sharedUsers")
    List<File> findBySharedUsers(@Param("user") User user);
}