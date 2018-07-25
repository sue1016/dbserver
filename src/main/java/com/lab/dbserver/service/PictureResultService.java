package com.lab.dbserver.service;

import com.lab.dbserver.DTO.PictureDTO;
import com.lab.dbserver.DTO.PictureResultDTO;
import com.lab.dbserver.Utils.FileStreamUtils;
import com.lab.dbserver.Utils.PathUtils;
import com.lab.dbserver.Utils.ResultUtils;
import com.lab.dbserver.VO.ResultVO;
import com.lab.dbserver.dataobject.PersonFeature;
import com.lab.dbserver.dataobject.PictureResult;
import com.lab.dbserver.dataobject.mulKeys.PictureMulKeys;
import com.lab.dbserver.repository.PictureResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

//"camera":"",
//        "sequence":"",
//        "frame":"",
//        "featureBlob":"",
//        "boxes":""
@Service
public class PictureResultService {
    @Autowired
    PictureResultRepository pictureResultRepository;


    /**
     * 插入一张图片的特征（特征矩阵 + 边框）
     * @param picFeature
     * @param camera
     * @param frame
     * @param sequence
     * @param boxes
     * @return
     */
    public ResultVO insert(MultipartFile picFeature, Integer camera, Integer frame, String sequence,String boxes){
        //生成特征路径
        String featureDirpath = PathUtils.genPicFeatureDirPath(camera,sequence);
        String featurepath = PathUtils.genPicFeaturePath(frame,camera,sequence);

        //生成图片路径
        String picpath = PathUtils.genPicturePath(frame,camera,sequence);


        File pic = new File(picpath);
        if(!pic.exists()){
            return ResultUtils.error(-1,"该特征所匹配的图片不存在");
        }

        //创建目录及存储
        int re = 0 ;
        try {
            re = FileStreamUtils.saveMultipartFile(picFeature,featureDirpath,featurepath);

        }catch (IOException e){
            return ResultUtils.error(-1,"存储特征失败");
        }
        if (re!=0){
            //Integer camera, String sequence, Integer frame, String pictureFeaturesPath, String boxes, String picturePath
            pictureResultRepository.save(new PictureResult(camera,sequence,frame,featurepath,boxes,picpath));
            return ResultUtils.success();
        }
        else {
            return ResultUtils.error(-1,"存储特征失败");
        }
    }



    public  ResultVO read(Integer camera, Integer frame, String sequence){
        PictureResult pictureResult = pictureResultRepository.findOne(new PictureMulKeys(camera,frame,sequence));

        //Integer camera, Integer frame, String sequence, MultipartFile features, String boxes

        String featurePath = PathUtils.genPicFeaturePath(frame,camera,sequence);
        File file = new File(featurePath);
        if (!file.exists())
            return ResultUtils.error(-1,"图片的路径输入错误");
        try {
            byte[] bytes = FileStreamUtils.converFileToBytes(new File(featurePath));
            PictureResultDTO pictureDTO = new PictureResultDTO(camera,frame,sequence,bytes,pictureResult.getBoxes());
            return ResultUtils.success(pictureDTO);
        }catch (IOException e){
            return ResultUtils.error(-1,"路径正确，读取一张图片的特征失败");
        }
    }
}
