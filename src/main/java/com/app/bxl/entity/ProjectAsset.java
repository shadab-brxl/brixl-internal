package com.app.bxl.entity;

import com.app.bxl.entity.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnTransformer;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * The persistent class for the project database table.
 *
 */
@Entity
@NamedQuery(name="ProjectAsset.findAll", query="SELECT p FROM ProjectAsset p")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectAsset {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    //bi-directional many-to-one association to Project
    @ManyToOne
    private Project project;

    @OneToOne
    private Property property;

    @Enumerated(EnumType.STRING)
    @Column(name="type", columnDefinition = "project_asset_type")
    @ColumnTransformer(write = "?::project_asset_type")
    private ProjectAssetTypeEnum projectAssetType;

    @Enumerated(EnumType.STRING)
    @Column(name="dev_type", columnDefinition = "device_type")
    @ColumnTransformer(write = "?::device_type")
    private DeviceTypeEnum devType;

    @Column(name="org_file_name")
    private String orgFileName;

    @Enumerated(EnumType.STRING)
    @Column(name="context")
    private ProjectAssetContextTypeEnum context;

    @Enumerated(EnumType.STRING)
    @Column(name="category")
    private ProjectAssetCategoryEnum category;

    @Column(name="img_url")
    private String imgUrl;

    @Column(name="description")
    private String description;

    @Column(name="disp_order")
    private Integer dispOrder;

    @Column(name="created_on")
    private Timestamp createdOn;

    @Column(name="updated_on")
    private Timestamp updatedOn;

}

