package com.lab.dbserver.repository;

import com.lab.dbserver.dataobject.Video;
import com.lab.dbserver.dataobject.mulKeys.PictureMulKeys;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video,PictureMulKeys>{
}
