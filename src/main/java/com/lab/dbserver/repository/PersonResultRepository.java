package com.lab.dbserver.repository;

import com.lab.dbserver.dataobject.PersonResult;
import com.lab.dbserver.dataobject.mulKeys.PersonResultKeys;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonResultRepository extends JpaRepository<PersonResult,PersonResultKeys>{
    List<PersonResult> findByPersonId(Integer personId);
}
