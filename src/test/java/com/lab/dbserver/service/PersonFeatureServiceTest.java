package com.lab.dbserver.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonFeatureServiceTest {

    @Autowired
    PersonFeatureService personFeatureService;

    @Test
    public void insert() {
        File file = new File("./51_f_1_person.mat");
        if (file.exists())
            System.out.println("打开成功");
        else
            System.out.println("文件未找到");
        InputStream inputStream;
        MockMultipartFile mockMultipartFile;
        try {
            inputStream = new FileInputStream(file);
            mockMultipartFile = new MockMultipartFile("file", inputStream);

            personFeatureService.insert(mockMultipartFile, 1, "201807205001");
        } catch (IOException e) {
            System.out.println("失败");
        }
    }

    @Test
    public void read() {
    }
}