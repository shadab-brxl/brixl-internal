package com.app.bxl.controller;

import com.app.bxl.request.ProjectRequest;
import com.app.bxl.response.BaseResponse;
import com.app.bxl.response.InitResponse;
import com.app.bxl.service.BasicDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
@Slf4j
public class BasicDetailsController {

    @Autowired
    private BasicDetailsService basicDetailsService;

    @PostMapping("/project")
    public BaseResponse handleProject(
            @RequestParam(required = false) String context,
            @RequestParam(required = false) UUID id,
            @RequestBody ProjectRequest request) {

        if ("init".equalsIgnoreCase(context)) {
            UUID newId = basicDetailsService.handleInit(request);
            return new InitResponse(HttpStatus.CREATED, 201, "Project initialized successfully", newId);

        } else if ("submit".equalsIgnoreCase(context)) {
            if (id == null)
                throw new IllegalArgumentException("Project ID is required for submit action.");

            basicDetailsService.handleSubmit(id, request);
            return new BaseResponse(HttpStatus.OK, 200, "Project submitted successfully");

        } else {
            if (id == null)
                throw new IllegalArgumentException("Project ID is required for update.");

            basicDetailsService.handleUpdate(id, request);
            return new BaseResponse(HttpStatus.OK, 200, "Project updated successfully");
        }
    }
}
