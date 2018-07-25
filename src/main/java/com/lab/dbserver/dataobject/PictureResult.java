package com.lab.dbserver.dataobject;

import com.lab.dbserver.dataobject.mulKeys.PictureMulKeys;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
@IdClass(PictureMulKeys.class)
public class PictureResult {

    @Id
    private Integer cameraId;

    @Id
    private String sequenceId;

    @Id
    private Integer frame;

    private String pictureFeaturesPath;

    private String boxes;

    private String picturePath;

    public PictureResult() {
    }

    public PictureResult(Integer cameraId, String sequenceId, Integer frame, String pictureFeaturesPath, String boxes, String picturePath) {
        this.cameraId = cameraId;
        this.sequenceId = sequenceId;
        this.frame = frame;
        this.pictureFeaturesPath = pictureFeaturesPath;
        this.boxes = boxes;
        this.picturePath = picturePath;
    }
}
