package com.lab.dbserver.controller;

import com.lab.dbserver.VO.ResultVO;
import com.lab.dbserver.service.PictureResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;

@RequestMapping(path = "./pictureResult")
public class PictureResultController {

    @Autowired
    PictureResultService pictureResultService;
    @GetMapping(path = "/download/{sequence}/{camera}/{frame}")
    public ResultVO download(@PathVariable("sequence") String sequrnce,
                             @PathVariable("camera") Integer camera,
                             @PathVariable("frame") Integer frame){
        return pictureResultService.read(camera,frame,sequrnce);
    }
    //camera:1,
    //sequence:"1",
    //frame:1,
    //file:.mat,
    //boxes:""
    @PostMapping(path = "/upload")
    private ResultVO upload(@PathParam("file")MultipartFile file,
                            @PathParam("sequence")String sequence,
                            @PathParam("camera")Integer camera,
                            @PathParam("frame")Integer frame,
                            @PathParam("boxes")String boxes){
        return pictureResultService.insert(file,camera,frame,sequence,boxes);
    }
}
