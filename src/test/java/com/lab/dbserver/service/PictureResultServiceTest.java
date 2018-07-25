package com.lab.dbserver.service;

import com.lab.dbserver.VO.ResultVO;
import com.lab.dbserver.repository.PictureResultRepository;
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
public class PictureResultServiceTest {

    @Autowired
    PictureResultService pictureResultService;
    @Test
    public void insert() {
        File file = new File("./51_f_15_features.mat");
        if (file.exists())
            System.out.println("打开成功");
        else
            System.out.println("文件未找到");
        InputStream inputStream;
        MockMultipartFile mockMultipartFile;
        try {
            inputStream = new FileInputStream(file);
            mockMultipartFile = new MockMultipartFile("file", inputStream);

            ResultVO resultVO = pictureResultService.insert(mockMultipartFile, 1, 51, "20180720001", "[[161, 281, 363, 699, 0], [742, 238, 771, 326, 0], [659, 274, 688, 356, 0], [704, 266, 733, 344, 0], [751, 254, 784, 342, 0], [413, 258, 435, 321, 0], [399, 263, 424, 332, 0], [990, 175, 1015, 250, 0], [158, 255, 196, 369, 0], [175, 259, 214, 373, 0], [174, 257, 198, 327, 0], [1145, 166, 1178, 271, 0], [192, 251, 214, 318, 0], [679, 260, 711, 350, 0], [977, 181, 1002, 253, 0]]");
            System.out.println(resultVO.getMsg());
        } catch (IOException e) {
            System.out.println("失败");
        }
    }

    @Test
    public void read() {
    }
}