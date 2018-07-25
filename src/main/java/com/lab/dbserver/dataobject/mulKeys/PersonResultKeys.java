package com.lab.dbserver.dataobject.mulKeys;


import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class PersonResultKeys implements Serializable {

    private Integer personId;

    private Integer startFrame;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PersonResultKeys that = (PersonResultKeys) o;
        return Objects.equals(personId, that.personId) &&
                Objects.equals(startFrame, that.startFrame);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), personId, startFrame);
    }
}
