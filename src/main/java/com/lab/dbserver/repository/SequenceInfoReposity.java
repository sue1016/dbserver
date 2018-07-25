package com.lab.dbserver.repository;

import com.lab.dbserver.dataobject.SequenceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SequenceInfoReposity extends JpaRepository<SequenceInfo,String>{
    List<SequenceInfo> findByStartDateBetween(Date start,Date finish);
}
