package com.app.bxl.entity;


import com.app.bxl.entity.enums.ProjectUploadStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;


import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="project_temp_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectTempData {


//    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;

    @Column(name = "temp_json", columnDefinition="jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private String tempJson;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "project_upload_status")
    @ColumnTransformer(write = "?::project_upload_status")
    private ProjectUploadStatusEnum status;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
