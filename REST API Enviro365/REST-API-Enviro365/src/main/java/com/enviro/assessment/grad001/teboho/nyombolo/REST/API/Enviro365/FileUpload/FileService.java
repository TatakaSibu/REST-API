package com.enviro.assessment.grad001.teboho.nyombolo.REST.API.Enviro365.FileUpload;

import com.enviro.assessment.grad001.teboho.nyombolo.REST.API.Enviro365.FileRepo.FileEntityRepo;
import com.enviro.assessment.grad001.teboho.nyombolo.REST.API.Enviro365.Model.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class FileService {

    @Autowired
    private FileEntityRepo fileEntityRepo;

    // Simulated database to store processed results
    private final Map<String, Map<String, String>> processedResults = new HashMap<>();

    public String processFile(MultipartFile file) throws IOException {
        String fileId = UUID.randomUUID().toString();
        // Simulate processing and storing the file
        String fileName = file.getOriginalFilename();
        Map<String, String> fileData = new HashMap<>();
        fileData.put("fileName", fileName);
        // Add more processing logic if needed
        processedResults.put(fileId, fileData);
        return fileId;
    }

    public Map<String, String> getProcessedResult(String fileId) {
        return processedResults.get(fileId);
    }

    public boolean deleteFile(String fileId) {
        return processedResults.remove(fileId) != null;
    }

    public boolean updateFile(String fileId, MultipartFile file) throws IOException {
        if (processedResults.containsKey(fileId)) {
            // Update the file data
            String fileName = file.getOriginalFilename();
            Map<String, String> fileData = new HashMap<>();
            fileData.put("fileName", fileName);
            // Update the processed results
            processedResults.put(fileId, fileData);
            return true;
        } else {
            return false;
        }
    }

    public FileEntity saveFile(FileEntity fileEntity) {
        return fileEntityRepo.save(fileEntity);
    }
}
