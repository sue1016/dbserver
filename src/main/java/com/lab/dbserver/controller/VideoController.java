package com.lab.dbserver.controller;

import com.lab.dbserver.VO.ResultVO;
import com.lab.dbserver.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
//pass
@RestController
public class VideoController {
    @Autowired
    VideoService videoService;

//values = {'sequence':"201807205001",'camera':1,"frame":51}
    //files = {'file': open("./51_f_pictures.mat","rb")}
    //r = requests.post(url,files = files,data=values)
    @PostMapping(path = "/picture/upload")
        public ResultVO upload(@PathParam(value = "file")MultipartFile file,
                           @PathParam(value = "sequence")String sequence,
                           @PathParam(value = "camera")Integer camera,
                           @PathParam(value = "frame")Integer frame){
        return videoService.insert(file,frame,camera,sequence);
    }

    @GetMapping(path = "/picture/download/{sequence}/{camera}/{frame}")
    public ResultVO download(@PathVariable(value = "sequence") String sequence,
                             @PathVariable(value = "camera") Integer camera,
                             @PathVariable(value = "frame") Integer frame){
        return videoService.read(frame,camera,sequence);
    }
}
