package com.app.bxl.controller;

import com.app.bxl.entity.ProjectTempData;
import com.app.bxl.response.InitResponse;
import com.app.bxl.service.InitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class initController {

    @Autowired
    private InitService initService;

    @PostMapping("/project/add/init")
    public ResponseEntity<InitResponse> initController() {
        try {
            ProjectTempData saved = initService.generateId();

            InitResponse response = new InitResponse(
                    HttpStatus.OK,
                    HttpStatus.OK.value(),
                    "project id generated successfully",
                    saved.getId()
            );
            return ResponseEntity.ok(response);
        }catch(Exception e){
            log.error("Error generating project ID: {}", e.getMessage(), e);

            InitResponse response = new InitResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    500,
                    "Failed to process the request , Error:" + e.getMessage()
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

}

