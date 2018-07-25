package com.lab.dbserver.controller;

import com.lab.dbserver.Utils.ResultUtils;
import com.lab.dbserver.VO.ResultVO;
import com.lab.dbserver.dataobject.SequenceInfo;
import com.lab.dbserver.repository.SequenceInfoReposity;
import com.lab.dbserver.service.SequenceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/sequence")
public class SequenceController {
    @Autowired
    SequenceInfoReposity sequenceInfoReposity;
    @Autowired
    SequenceInfoService sequenceInfoService;

    @GetMapping(path = "/download/{sequenceId}")
    public ResultVO read(@PathVariable("sequenceId") String sequenceId){
        SequenceInfo sequenceInfo = sequenceInfoReposity.findOne(sequenceId);
        if (sequenceInfo == null)
            return ResultUtils.error(-1,"新输入的序列编号在数据库中没有匹配");
        return ResultUtils.success(sequenceInfo);
    }

    @PostMapping(path = "/upload/{startDate}/{finishDate}")
    public ResultVO upload(@PathVariable("startDate") Date startDate,
                           @PathVariable("finishDate") Date finishDate){

        return sequenceInfoService.create(startDate,finishDate);
    }
}
