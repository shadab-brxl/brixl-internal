package com.app.bxl.repository;

import com.app.bxl.entity.Lead;
import com.app.bxl.pojo.LeadBasicDetails;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface LeadRepository extends JpaRepository<Lead, UUID> {

    @Query(value = "SELECT id, name, contact, lead_context, " +
            "lead_origin, created_on, project_id " +
            "FROM lead " +
            "ORDER BY created_on DESC",
            nativeQuery = true)
    List<LeadBasicDetails> findAllLeadsBasic(Pageable pageable);

    @Query(
            value = "SELECT id, name, contact, lead_context, lead_origin, created_on, project_id " +
                    "FROM lead ORDER BY created_on DESC LIMIT :size OFFSET :offset",
            nativeQuery = true
    )
    List<LeadBasicDetails> findLeadsWithOffset(@Param("offset") int offset, @Param("size") int size);



}
