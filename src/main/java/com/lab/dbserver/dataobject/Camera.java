package com.lab.dbserver.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Camera {
    @Id
    @GeneratedValue
    private Integer cameraId;

    private String cameraLocation;

    public Camera() {
    }

    public Camera(String cameraLocation) {
        this.cameraLocation = cameraLocation;
    }
}
