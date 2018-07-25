package com.lab.dbserver.dataobject;

import com.lab.dbserver.dataobject.mulKeys.PersonFeatureKeys;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
@IdClass(PersonFeatureKeys.class)
public class PersonFeature {
    @Id
    private Integer personId;

    @Id
    private String sequenceId;


    private String featurePath;

    public PersonFeature() {
    }

    public PersonFeature(Integer personId, String sequenceId, String featurePath) {
        this.personId = personId;
        this.sequenceId = sequenceId;
        this.featurePath = featurePath;
    }
}
