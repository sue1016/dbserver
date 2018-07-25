package com.lab.dbserver.DTO;

import lombok.Data;

//"camera":"1",
//"sequence":"1",
//"personId":""
@Data
public class PersonResultDTO {
    private Integer cameraId;

    private Integer personId;

    private String sequence;
}
