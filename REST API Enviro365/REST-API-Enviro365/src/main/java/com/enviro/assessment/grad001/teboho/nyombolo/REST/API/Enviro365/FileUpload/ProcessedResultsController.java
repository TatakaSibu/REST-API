package com.enviro.assessment.grad001.teboho.nyombolo.REST.API.Enviro365.FileUpload;

import com.enviro.assessment.grad001.teboho.nyombolo.REST.API.Enviro365.FileRepo.FileEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProcessedResultsController {
    @Autowired
    private FileService fileService;

    @Autowired
    FileEntityRepo fileEntityRepo;

    @GetMapping("/results/{fileId}")
    public ResponseEntity<String> getProcessedResult(@PathVariable Long fileId) {
        try {
            Map<String, String> processedResult = fileService.getProcessedResult(String.valueOf(fileId));
            if (processedResult != null) {
                return ResponseEntity.ok("GET request processed successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File ID not found: " + fileId);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve processed result: " + e.getMessage());
        }
    }


}
