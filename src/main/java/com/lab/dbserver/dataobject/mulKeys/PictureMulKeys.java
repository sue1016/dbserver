package com.lab.dbserver.dataobject.mulKeys;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class PictureMulKeys implements Serializable{
    private Integer cameraId;

    private String sequenceId;

    private Integer frame;

    public PictureMulKeys() {
    }

    public PictureMulKeys(Integer cameraId,  Integer frame,String sequenceId) {
        this.cameraId = cameraId;
        this.sequenceId = sequenceId;
        this.frame = frame;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PictureMulKeys that = (PictureMulKeys) o;
        return Objects.equals(cameraId, that.cameraId) &&
                Objects.equals(sequenceId, that.sequenceId) &&
                Objects.equals(frame, that.frame);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), cameraId, sequenceId, frame);
    }
}
