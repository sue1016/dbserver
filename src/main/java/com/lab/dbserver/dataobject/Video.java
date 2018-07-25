package com.lab.dbserver.dataobject;

import com.lab.dbserver.dataobject.mulKeys.PictureMulKeys;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
@IdClass(PictureMulKeys.class)
public class Video {
    @Id
    private String sequenceId;

    @Id
    private Integer cameraId;

    @Id
    private Integer frame;

    private String picturePath;
}
