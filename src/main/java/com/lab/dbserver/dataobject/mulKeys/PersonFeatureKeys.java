package com.lab.dbserver.dataobject.mulKeys;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class PersonFeatureKeys implements Serializable{
    private Integer personId;

    private String sequenceId;

    public PersonFeatureKeys(Integer personId, String sequenceId) {
        this.personId = personId;
        this.sequenceId = sequenceId;
    }

    public PersonFeatureKeys() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PersonFeatureKeys that = (PersonFeatureKeys) o;
        return Objects.equals(personId, that.personId) &&
                Objects.equals(sequenceId, that.sequenceId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), personId, sequenceId);
    }
}
