package com.app.bxl.config;

import com.app.bxl.response.LeadResponse;
import com.app.bxl.service.LeadService;
import com.app.bxl.utility.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

//@Slf4j
//public class DataLoader {

//    @Autowired
//    private LeadService leadService;
//
//    private void loadBankHLRData() {
//        try {
//            LeadResponse response = leadService.listLeads();
//            log.info("Bank HLR response : {}", response);
//
//            if (response != null && response.getData() != null) {
//                for (LeadResponse.LeadData lead : response.getData()) {
//                    AppConstants.LeadMap.put(lead.getC_name(), lead);
//                    log.info("BankHLRMap populated: {} -> {}", bank.getName(), bank.getRates());
//                }
//            } else {
//                log.warn("No bank HLR data found in response");
//            }
//
//            log.info("Final BankHLRMap: {}", AppConstants.BankHLRMap);
//        } catch (RuntimeException e) {
//            log.error("Runtime exception while loading bank HLR data: {}", e.getMessage(), e);
//        } catch (Exception e) {
//            log.error("Exception while loading bank HLR data: {}", e.getMessage(), e);
//        }
//    }
//}
