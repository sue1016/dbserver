package com.lab.dbserver.service;

import com.lab.dbserver.DTO.PictureDTO;
import com.lab.dbserver.VO.ResultVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class VideoServiceTest {

    @Autowired
    VideoService videoService;
    @Test
    public void insert() {
        File file = new File("./51_f_pictures.mat");
        if (file.exists())
            System.out.println("打开成功");
        else
            System.out.println("文件未找到");
        InputStream inputStream;
        MockMultipartFile mockMultipartFile;
        try {
            inputStream = new FileInputStream(file);
            mockMultipartFile = new MockMultipartFile("file",inputStream);

            ResultVO resultVO = videoService.insert(mockMultipartFile,51,1,"201807205001");
            System.out.println(resultVO.getMsg());
        }
        catch (FileNotFoundException e){
            System.out.println("文件输入流未创建");
        }
        catch (IOException e)
        {

        }


    }

    @Test
    public void read(){
        ResultVO resultVO = videoService.read(1,1,"201807205001");
        System.out.println(resultVO.getData().toString());
    }
}