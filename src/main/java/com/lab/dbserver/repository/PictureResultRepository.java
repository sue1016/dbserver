package com.lab.dbserver.repository;

import com.lab.dbserver.dataobject.PictureResult;
import com.lab.dbserver.dataobject.mulKeys.PictureMulKeys;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureResultRepository extends JpaRepository<PictureResult,PictureMulKeys>{
}
