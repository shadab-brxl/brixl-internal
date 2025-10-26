package com.app.bxl.repository;

import com.app.bxl.entity.ProjectTempData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ProjectTempDataRepository extends JpaRepository<ProjectTempData, UUID> {

    @Query(value = "SELECT * FROM project_temp_data WHERE id = :id", nativeQuery = true)
    ProjectTempData findByNId(@Param("id") UUID id);

}
