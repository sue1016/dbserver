package com.lab.dbserver.repository;
import com.lab.dbserver.dataobject.Camera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CameraRepository extends JpaRepository<Camera,Integer>{
}
