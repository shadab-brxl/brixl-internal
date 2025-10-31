package com.app.bxl.repository;

import com.app.bxl.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID> {

    @Query(value = "SELECT name FROM project p WHERE id = :projectId", nativeQuery = true)
    String findProjectNameById(@Param("projectId") UUID projectId);

}
