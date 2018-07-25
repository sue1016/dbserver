package com.lab.dbserver.Utils;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;

import java.io.*;

import static org.junit.Assert.*;

public class PathUtilsTest {
    private String sequenceId = "201807205001";

    private Integer cameraId = 1;

    private Integer frame = 1;

    @Test
    public void genPicFeaturePath() {
        System.out.println(PathUtils.genPicturePath(frame,cameraId,sequenceId));
    }

    @Test
    public void genPersonFeaturePath() {
        System.out.println(PathUtils.genPersonFeaturePath(3,sequenceId));
    }

    @Test
    public void genPicturePath() {
        System.out.println(PathUtils.genPicFeaturePath(frame,cameraId,sequenceId));
    }

    @Test
    public void FileOutTest() {
        try {
            File file = new File("./1.png");
            if (file.exists())
                System.out.println("文件打开成功");
            InputStream inputStream = new FileInputStream(file);
            MockMultipartFile mockMultipartFile = new MockMultipartFile("file",inputStream);
//            BufferedOutputStream out = new BufferedOutputStream(
//                    new FileOutputStream(new File("./data/1111.png")));//保存图片到目录下
//            out.write(mockMultipartFile.getBytes());
//            out.flush();
//            out.close();
            if(new File("./data/pic/1111.png").mkdirs())
                mockMultipartFile.transferTo(new File("./data/pic/1111.png"));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("文件未找到");
        }
        catch (IOException e){
            System.out.println("文件存储失败");
        }
    }
}