package com.lab.dbserver.service;

import com.lab.dbserver.Utils.ResultUtils;
import com.lab.dbserver.VO.ResultVO;
import com.lab.dbserver.dataobject.Camera;
import com.lab.dbserver.repository.CameraRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CameraService {


    @Autowired
    CameraRepository cameraRepository;
    /**
     * 增加一个相机
     */
    public ResultVO create(Camera camera){
        cameraRepository.save(camera);
        return ResultUtils.success(camera);
    }

    /**
     * 查询相机的位置
     */
    public ResultVO getLocation(Integer id){
        Camera camera = cameraRepository.findOne(id);
        if(camera!=null){
            return ResultUtils.success(camera.getCameraLocation());
        }
        else {
            return ResultUtils.error(-1,"您输入的相机编号在数据库中没有匹配");
        }
    }


}
