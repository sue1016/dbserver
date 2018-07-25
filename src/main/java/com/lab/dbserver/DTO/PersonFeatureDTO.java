package com.lab.dbserver.DTO;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PersonFeatureDTO {
    private Integer personId;
    private String sequenceId;
    private byte[] feature;

    public PersonFeatureDTO() {
    }

    public PersonFeatureDTO(Integer personId, String sequenceId, byte[] feature) {
        this.personId = personId;
        this.sequenceId = sequenceId;
        this.feature = feature;
    }
}
