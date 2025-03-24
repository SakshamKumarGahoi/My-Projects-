package com.cloud.filesharing.service;
import com.cloud.filesharing.entity.File;
import com.cloud.filesharing.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class FileService {
@Autowired
    private FileRepository fileRepository;
    public File saveFile(File file){
        return fileRepository.save(file);
    }

    public List<File> findAllFiles() {
        return fileRepository.findAll();
    }

    public File findFileById(Long fileId){
        return fileRepository.findById(fileId).orElse(null);
    }

    public void deleteFile(Long fileId){
        fileRepository.deleteById(fileId);
    }
}