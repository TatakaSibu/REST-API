package com.enviro.assessment.grad001.teboho.nyombolo.REST.API.Enviro365.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Files")
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fileId;
    private String fileName;

    public FileEntity() {
    }

    public FileEntity(Long fileId, String fileName) {
        this.fileId = fileId;
        this.fileName = fileName;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "fileId='" + fileId + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
