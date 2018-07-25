package com.lab.dbserver.service;

import com.lab.dbserver.Utils.ResultUtils;
import com.lab.dbserver.VO.ResultVO;
import com.lab.dbserver.dataobject.PersonResult;
import com.lab.dbserver.repository.PersonResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//    private Integer personId;
//
//    private Integer camera;
//
//    private String sequence;
//
//    @Id
//    private Integer startFrame;
//
//    private Integer finishFrame;
//PersonResult(Integer personId,Integer camera, String sequence, Integer startFrame, Integer finishFrame)
@Service
public class PersonResultService {

    @Autowired
    PersonResultRepository personResultRepository;

    public ResultVO insert(Integer personId,Integer camera, String sequence, Integer startFrame, Integer finishFrame){
        PersonResult personResult = new PersonResult(personId, camera,  sequence,  startFrame,  finishFrame);
        return ResultUtils.success(personResultRepository.save(personResult));
    }


    public ResultVO find(Integer personId){
        List<PersonResult> list = personResultRepository.findByPersonId(personId);
        return ResultUtils.success(list);
    }
}
