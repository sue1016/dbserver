package com.lab.dbserver.dataobject;

import com.lab.dbserver.dataobject.mulKeys.PersonResultKeys;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
@IdClass(PersonResultKeys.class)
public class PersonResult {
    @Id
    private Integer personId;


    @Id
    private Integer startFrame;

    private Integer cameraId;

    private String sequenceId;


    private Integer finishFrame;

    public PersonResult() {
    }

    public PersonResult(Integer personId,Integer cameraId, String sequenceId, Integer startFrame, Integer finishFrame) {
        this.personId = personId;
        this.cameraId = cameraId;
        this.sequenceId = sequenceId;
        this.startFrame = startFrame;
        this.finishFrame = finishFrame;
    }

    @Override
    public String toString() {
        return "PersonResult{" +
                "personId=" + personId +
                ", cameraId=" + cameraId +
                ", sequenceId='" + sequenceId + '\'' +
                ", startFrame=" + startFrame +
                ", finishFrame=" + finishFrame +
                '}';
    }
}
