package com.app.bxl.service;

import com.app.bxl.entity.ProjectTempData;
import com.app.bxl.repository.ProjectTempDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class InitService {

    @Autowired
    private ProjectTempDataRepository projectTempDataRepository;

    public ProjectTempData generateId(){

        try {
            UUID randomUUID = UUID.randomUUID();

            ProjectTempData data = new ProjectTempData();
            data.setId(randomUUID);
            data.setTempJson("{}");

            return projectTempDataRepository.save(data);
        }catch(Exception e){
            log.error("Error generating projectId :{}", e.getMessage(), e);
            throw e;
        }
    }
}
