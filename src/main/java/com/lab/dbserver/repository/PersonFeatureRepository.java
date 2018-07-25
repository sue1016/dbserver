package com.lab.dbserver.repository;

import com.lab.dbserver.dataobject.PersonFeature;
import com.lab.dbserver.dataobject.mulKeys.PersonFeatureKeys;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonFeatureRepository extends JpaRepository<PersonFeature,PersonFeatureKeys>{
}
