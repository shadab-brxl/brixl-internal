package com.app.bxl.controller;

import com.app.bxl.response.LeadResponse;
import com.app.bxl.service.LeadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@Slf4j
@RestController
@RequestMapping("/api")
public class LeadController {

    @Autowired
    private LeadService leadService;

    @GetMapping("/leads")
    public ResponseEntity<LeadResponse> getAllLeads(
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "10") int size
    ) {
        LeadResponse response = leadService.listLeads(offset, size);
        return ResponseEntity
                .status(response.getHttpStatus())
                .body(response);
    }
}
