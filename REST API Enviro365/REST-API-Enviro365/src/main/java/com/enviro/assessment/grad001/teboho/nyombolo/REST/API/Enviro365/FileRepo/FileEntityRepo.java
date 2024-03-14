package com.enviro.assessment.grad001.teboho.nyombolo.REST.API.Enviro365.FileRepo;

import com.enviro.assessment.grad001.teboho.nyombolo.REST.API.Enviro365.Model.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileEntityRepo extends JpaRepository<FileEntity, Long> {

}
