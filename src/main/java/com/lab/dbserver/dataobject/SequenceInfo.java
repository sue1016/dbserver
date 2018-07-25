package com.lab.dbserver.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class SequenceInfo {
    @Id
    private String sequenceId;

    private Date startDate;

    // yyyy-MM-dd hh:mm:ss
    private Date finishDate;

    public SequenceInfo() {
    }

    public SequenceInfo(String sequenceId, Date startDate, Date finishDate) {
        this.sequenceId = sequenceId;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }
}
