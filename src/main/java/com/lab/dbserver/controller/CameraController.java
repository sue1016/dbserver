package com.lab.dbserver.controller;

import com.lab.dbserver.Utils.ResultUtils;
import com.lab.dbserver.VO.ResultVO;
import com.lab.dbserver.dataobject.Camera;
import com.lab.dbserver.repository.CameraRepository;
import com.lab.dbserver.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/camera")
public class CameraController {
    @Autowired
    CameraRepository cameraRepository;

    @Autowired
    CameraService cameraService;

    @GetMapping("/download/{cameraId}")
    public ResultVO getCameraInfo(@PathVariable(value = "cameraId") Integer cameraId){
        return cameraService.getLocation(cameraId);

    }

    @PostMapping("/upload/{cameraLocation}")
    public ResultVO getCameraInfo(@PathVariable(value = "cameraLocation")String cameraLocation){
        Camera camera = new Camera(cameraLocation);
        return ResultUtils.success(camera);
    }
}
