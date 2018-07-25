package com.lab.dbserver.controller;

import com.lab.dbserver.VO.ResultVO;
import com.lab.dbserver.repository.PersonResultRepository;
import com.lab.dbserver.service.PersonResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("./personResult")
public class PersonResultController {
    @Autowired
    PersonResultService personResultService;
    //"camera":,
    //"sequence":"",
    //"personId":,
    //"startFrame":,
    //"finishFrame":
    @PostMapping(path = "upload")
    public ResultVO upload(String sequence,Integer camera,Integer personId,Integer startFrame,Integer finishFrame){
        return personResultService.insert(personId,camera,sequence,startFrame,finishFrame);
    }

    @GetMapping(path = "download/{personId}")
    public ResultVO upload(@PathVariable(value = "personId") Integer personId){
        return personResultService.find(personId);
    }

}
