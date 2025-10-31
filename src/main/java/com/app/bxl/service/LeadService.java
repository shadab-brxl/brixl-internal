package com.app.bxl.service;

import com.app.bxl.pojo.LeadBasicDetails;
import com.app.bxl.repository.LeadRepository;
import com.app.bxl.repository.ProjectRepository;
import com.app.bxl.repository.ProjectTempDataRepository;
import com.app.bxl.repository.PropertyRepository;
import com.app.bxl.response.LeadResponse;
import com.app.bxl.utility.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;



@Service
@Slf4j
public class LeadService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectTempDataRepository projectTempDataRepository;

    @Autowired
    private LeadRepository leadRepository;

    public LeadResponse listLeads(int page, int size ){

//        final int FIXED_PAGE_SIZE = AppConstants.FIXED_PAGE_SIZE;
//        int offset = page * FIXED_PAGE_SIZE; // TRUE RAW OFFSET
//        List<LeadBasicDetails> leads = leadRepository.findLeadsWithOffset(offset, size);

        final int FIXED_PAGE_SIZE = AppConstants.FIXED_PAGE_SIZE;
        int finalSize = Math.min(size, FIXED_PAGE_SIZE);
        List<LeadResponse.LeadData> leadDataList = new ArrayList<>();

        for (int i = 0; i < finalSize; i++) {
            LeadResponse.LeadData dto = new LeadResponse.LeadData();

            dto.setC_id(UUID.fromString("b7f84a91-2d44-4b49-9b9c-8a47c2e4f18a"));
            dto.setC_name("Dummy");
            dto.setC_number("+91 9945154084");
            dto.setLead_context("Interest");
            dto.setLead_origin("LOAN");
            dto.setGenerated_at(Instant.now().toEpochMilli());
            dto.setProject_id(UUID.fromString("21b2d4ca-78bb-47fc-93e8-755aec022a58"));
            dto.setP_name("Sunrise Residency");
            dto.setP_type(new HashSet<>(Arrays.asList("APARTMENT", "PLOT")));

            leadDataList.add(dto);
//            return dto;
//        }).toList();
        }
        return new LeadResponse(HttpStatus.OK, 200, "SUCCESS", leadDataList);
    }
}
