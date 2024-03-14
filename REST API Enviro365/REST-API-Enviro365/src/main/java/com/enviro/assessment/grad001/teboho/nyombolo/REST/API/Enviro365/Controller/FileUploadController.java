package com.enviro.assessment.grad001.teboho.nyombolo.REST.API.Enviro365.Controller;

import com.enviro.assessment.grad001.teboho.nyombolo.REST.API.Enviro365.FileRepo.FileEntityRepo;
import com.enviro.assessment.grad001.teboho.nyombolo.REST.API.Enviro365.FileUpload.FileService;
import com.enviro.assessment.grad001.teboho.nyombolo.REST.API.Enviro365.Model.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class FileUploadController {
    @Autowired
    private FileService fileService;

    @Autowired
    FileEntityRepo fileEntityRepo;



    @PostMapping("/api/upload")
    public ResponseEntity<Map<String, String>> uploadFile(@RequestParam("file") MultipartFile file) {
        // Process file and create FileEntity object
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileName(file.getOriginalFilename());

        // Save FileEntity object to database
        FileEntity savedFile = fileService.saveFile(fileEntity);

        // Construct response
        Map<String, String> response = new HashMap<>();
        response.put("message", "File uploaded successfully with ID: " + savedFile.getFileId());

        return ResponseEntity.ok(response);
    }

//    @PostMapping("/api/upload")
//    public ResponseEntity<FileEntity> uploadFile(@RequestBody FileEntity fileEntity) {
//        FileEntity savedFile = fileService.saveFile(fileEntity);
//        return ResponseEntity.ok(savedFile);
//    }

    @DeleteMapping("/delete/{fileId}")
    public ResponseEntity<Long> deleteFile(@PathVariable Long fileId) {
        boolean deleted = fileService.deleteFile(String.valueOf(fileId));
        if (deleted) {
            return ResponseEntity.ok(Long.valueOf("File deleted successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Long.valueOf("File ID not found: " + fileId));
        }
    }

    @PutMapping("/update/{fileId}")
    public ResponseEntity<Long> updateFile(@PathVariable Long fileId, @RequestParam("file") MultipartFile file) {
        try {
            boolean updated = fileService.updateFile(String.valueOf(fileId), file);
            if (updated) {
                return ResponseEntity.ok(Long.valueOf("File updated successfully"));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Long.valueOf("File ID not found: " + fileId));
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Long.valueOf("Failed to update file: " + e.getMessage()));
        }
    }
}
