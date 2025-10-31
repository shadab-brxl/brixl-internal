package com.app.bxl.entity;

import com.app.bxl.entity.enums.DeviceTypeEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnTransformer;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
public class Lead {

    @Id
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "contact", nullable = false)
    private String contact;

    @Column(name = "city_code", nullable = false)
    private String cityCode;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

    @Column(name = "lead_origin")
    private String leadOrigin;

    @Column(name = "lead_context")
    private String leadContext;


    @Enumerated(EnumType.STRING)
    @Column(name = "dev_type")
    @ColumnTransformer(write = "?::device_type")
    private DeviceTypeEnum deviceType;

    @Column(name = "project_id")
    private UUID projectId;
}


