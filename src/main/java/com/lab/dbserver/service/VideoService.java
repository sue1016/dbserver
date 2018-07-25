package com.lab.dbserver.service;

import com.lab.dbserver.DTO.PictureDTO;
import com.lab.dbserver.Utils.FileStreamUtils;
import com.lab.dbserver.Utils.PathUtils;
import com.lab.dbserver.Utils.ResultUtils;
import com.lab.dbserver.VO.ResultVO;
import com.lab.dbserver.dataobject.Video;
import com.lab.dbserver.repository.VideoRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class VideoService {

    @Autowired
    VideoRepository videoRepository;

    /**
     * 增加一张图片
     */
    public ResultVO insert(MultipartFile multipartFile,Integer frame,Integer camera,String sequence){
        if(multipartFile.isEmpty())
            System.out.println("上传文件为空");

        Video video = new Video();

        video.setCameraId(camera);
        video.setFrame(frame);
        video.setSequenceId(sequence);

        String filepath = PathUtils.genPicturePath(frame,camera,sequence);
        String fileDirpath = PathUtils.genPictureDirPath(camera,sequence);

        try {
            FileStreamUtils.saveMultipartFile(multipartFile,fileDirpath,filepath);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("文件未找到");
            return ResultUtils.error(-1,"文件未找到");
        }
        catch (IOException e){
            System.out.println("文件存储失败");
            return ResultUtils.error(-1,"文件存储失败");
        }
        video.setPicturePath(filepath);


        return ResultUtils.success(videoRepository.save(video));
    }

    /**
     * 查询一张图片
     * @param frame
     * @param camera
     * @param sequence
     * @return
     */
    public ResultVO read(Integer frame,Integer camera,String sequence){
        String filepath = PathUtils.genPicturePath(frame,camera,sequence);
        File file = new File(filepath);
        if(!file.exists()){
            return ResultUtils.error(-1,"输入路径不存在");
        }
        try {
            InputStream inputStream = new FileInputStream(file);
//Integer frame, Integer cameraId, String sequenceId
            System.out.println(IOUtils.toByteArray(inputStream).length);
            return ResultUtils.success(new PictureDTO(IOUtils.toByteArray(inputStream),frame,camera,sequence));
        }
        catch (IOException e){
            return ResultUtils.error(-1,"文件读取失败"+e.getMessage());
        }
    }
}
