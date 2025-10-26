package com.app.bxl.service;

import com.app.bxl.entity.ProjectTempData;
import com.app.bxl.entity.enums.ProjectUploadStatusEnum;
import com.app.bxl.repository.ProjectTempDataRepository;
import com.app.bxl.request.ProjectRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.UUID;



@Service
@Slf4j
public class BasicDetailsService {

    @Autowired
    private ProjectTempDataRepository projectTempDataRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public UUID handleInit(ProjectRequest request) {
        try {
            UUID projectId = UUID.randomUUID();
            ProjectTempData tempData = new ProjectTempData();

            tempData.setId(projectId);
            tempData.setTempJson(objectMapper.writeValueAsString(request));
            tempData.setStatus(ProjectUploadStatusEnum.IN_PROGRESS);

            projectTempDataRepository.save(tempData);
            return projectId;
        } catch (Exception e) {
            log.error("Init failed", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to initialize project");
        }
    }

    public void handleUpdate(UUID projectId, ProjectRequest request) {
        ProjectTempData existing = projectTempDataRepository.findById(projectId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found"));

        try {
            JsonNode existingJson = objectMapper.readTree(existing.getTempJson());
            JsonNode newJson = objectMapper.valueToTree(request);
            JsonNode merged = mergeJson(existingJson, newJson);

            existing.setTempJson(objectMapper.writeValueAsString(merged));
            projectTempDataRepository.save(existing);
        } catch (Exception e) {
            log.error("Update failed for {}", projectId, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to update project");
        }
    }


    public void handleSubmit(UUID projectId, ProjectRequest request) {
        ProjectTempData existing = projectTempDataRepository.findById(projectId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found"));

        try {
            JsonNode existingJson = objectMapper.readTree(existing.getTempJson());
            JsonNode newJson = objectMapper.valueToTree(request);
            JsonNode merged = mergeJson(existingJson, newJson);

            existing.setTempJson(objectMapper.writeValueAsString(merged));
            existing.setStatus(ProjectUploadStatusEnum.PENDING_APPROVAL);
            projectTempDataRepository.save(existing);
        } catch (Exception e) {
            log.error("Submit failed for {}", projectId, e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to submit project");
        }
    }

//    private JsonNode mergeJson(JsonNode existing, JsonNode updates) {
//        ObjectNode merged = existing.deepCopy();
//        updates.fieldNames().forEachRemaining(field -> {
//            JsonNode value = updates.get(field);
//            if (value != null && !value.isNull()) {
//                merged.set(field, value);
//            }
//        });
//        return merged;
//    }

    private JsonNode mergeJson(JsonNode existing, JsonNode updates) {
        if (existing == null) {
            return updates == null ? null : updates.deepCopy();
        }
        if (updates == null) {
            return existing.deepCopy();
        }

        ObjectNode merged = existing.deepCopy();
        updates.fieldNames().forEachRemaining(field -> {
            JsonNode value = updates.get(field);
            if (value != null && !value.isNull()) {
                if (merged.has(field) && merged.get(field).isObject() && value.isObject()) {
                    merged.set(field, mergeJson(merged.get(field), value));
                } else {
                    merged.set(field, value); // otherwise just overwrite
                }
            }
        });

        return merged;
    }

}
