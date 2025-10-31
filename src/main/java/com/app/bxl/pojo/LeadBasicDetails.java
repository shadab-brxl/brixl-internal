package com.app.bxl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadBasicDetails {
    private UUID id;
    private String name;
    private String contact;
    private String leadContext;
    private String leadOrigin;
    private Timestamp createdOn;
    private UUID projectId;

}
