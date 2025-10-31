package com.app.bxl.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadResponse extends BaseResponse{

    public LeadResponse(HttpStatus httpStatus, int statusCode, String message){
        super(httpStatus, statusCode, message);
    }

    public LeadResponse(HttpStatus httpStatus, int statusCode, String message, List<LeadData> leads){
        super(httpStatus, statusCode, message);
        Data embed = this.new Data();
        embed.setLeads(leads);
        this.setData(embed);
    }

    @lombok.Data
    public class Data {
        private List<LeadData> leads;
    }

    @lombok.Data
    public static class LeadData {
        private UUID c_id;
        private String c_name;
        private String c_number;
        private String lead_context;
        private String lead_origin;
        private UUID project_id;
        private String p_name;
        private java.util.Set<String> p_type;
        private long generated_at;
    }

    private Data data;

}
