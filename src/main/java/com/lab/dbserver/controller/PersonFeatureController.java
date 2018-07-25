package com.lab.dbserver.controller;

import com.lab.dbserver.VO.ResultVO;
import com.lab.dbserver.service.PersonFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
//pass
@RestController
@RequestMapping("/personFeature")
public class PersonFeatureController {
    @Autowired
    PersonFeatureService personFeatureService;

    @GetMapping("/download/{sequence}/{personId}")
    public ResultVO download(@PathVariable(value = "sequence") String sequence,
                             @PathVariable(value = "personId") Integer personId){
        return personFeatureService.read(personId,sequence);
    }
    //"file":.mat,
    //"sequence":"",
    //"personId":,
    @PostMapping("/upload")
    public ResultVO upload(@PathParam(value = "file") MultipartFile file,
                           @PathParam(value = "sequence") String sequence,
                           @PathParam(value = "personId") Integer personId){
        return personFeatureService.insert(file,personId,sequence);
    }
}
