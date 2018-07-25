package com.lab.dbserver.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SequenceInfoServiceTest {

    @Autowired
    SequenceInfoService sequenceInfoService;
    @Test
    public void create() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR,  1);
        Date date1 = c.getTime();
        sequenceInfoService.create(date,date1);
    }
}