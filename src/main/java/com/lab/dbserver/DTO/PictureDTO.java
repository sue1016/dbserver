package com.lab.dbserver.DTO;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PictureDTO {

    byte[] file;
    Integer frame;
    Integer cameraId;
    String sequenceId;

    public PictureDTO(byte[] file, Integer frame, Integer cameraId, String sequenceId) {
        this.file = file;
        this.frame = frame;
        this.cameraId = cameraId;
        this.sequenceId = sequenceId;
    }

    public PictureDTO() {

    }

    @Override
    public String toString() {
        return "PictureDTO{" +
                "file=" + file +
                ", frame=" + frame +
                ", cameraId=" + cameraId +
                ", sequenceId='" + sequenceId + '\'' +

                '}';
    }
}
