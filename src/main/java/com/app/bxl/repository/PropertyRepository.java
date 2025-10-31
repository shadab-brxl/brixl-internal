package com.app.bxl.repository;

import com.app.bxl.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PropertyRepository extends JpaRepository<Property, UUID> {

    @Query(value = "SELECT DISTINCT property_type FROM property p " +
            "WHERE project_id = :projectId", nativeQuery = true)
    List<String> findDistinctPropertyTypesByProjectId(@Param("projectId") UUID projectId);

}
