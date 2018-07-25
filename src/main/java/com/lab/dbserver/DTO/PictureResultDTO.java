package com.lab.dbserver.DTO;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PictureResultDTO {
    private Integer cameraId;
    private Integer frame;
    private String sequenceId;

    private byte[] features;

    private String boxes;

    public PictureResultDTO() {
    }

    public PictureResultDTO(Integer cameraId, Integer frame, String sequenceId, byte[] features, String boxes) {
        this.cameraId = cameraId;
        this.frame = frame;
        this.sequenceId = sequenceId;
        this.features = features;
        this.boxes = boxes;
    }

    @Override
    public String toString() {
        return "PictureResultDTO{" +
                "cameraId=" + cameraId +
                ", frame=" + frame +
                ", sequenceId='" + sequenceId + '\'' +
                ", features=" + features.length +
                ", boxes='" + boxes + '\'' +
                '}';
    }
}
