package com.lab.dbserver.service;

import com.lab.dbserver.VO.ResultVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonResultServiceTest {

    @Autowired
    PersonResultService personResultService;

    @Test
    public void insert() {
        //(Integer personId,Integer camera, String sequence, Integer startFrame, Integer finishFrame)
        ResultVO resultVO = personResultService.insert(1,1,"201807205001",10,20);
        System.out.println(resultVO.getMsg());
    }

    @Test
    public void read() {
        ResultVO resultVO = personResultService.find(1);
        System.out.println(resultVO.getData().toString());
    }
}