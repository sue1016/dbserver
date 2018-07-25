package com.lab.dbserver.service;

import com.lab.dbserver.DTO.PersonFeatureDTO;
import com.lab.dbserver.Utils.FileStreamUtils;
import com.lab.dbserver.Utils.PathUtils;
import com.lab.dbserver.Utils.ResultUtils;
import com.lab.dbserver.VO.ResultVO;
import com.lab.dbserver.dataobject.PersonFeature;
import com.lab.dbserver.dataobject.mulKeys.PersonFeatureKeys;
import com.lab.dbserver.repository.PersonFeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class PersonFeatureService {

    @Autowired
    PersonFeatureRepository personFeatureRepository;


    /**
     * 想数据库中插入一个人的特征
     * @param multipartFile
     * @param personId
     * @param sequence
     * @return
     */
    public ResultVO insert(MultipartFile multipartFile,Integer personId, String sequence){
        //生成特征路径
        String fileDirpath = PathUtils.genPersonFeatureDirPath(sequence);
        String filepath = PathUtils.genPersonFeaturePath(personId,sequence);

        //创建目录及存储
        int re = 0 ;
        try {
            re = FileStreamUtils.saveMultipartFile(multipartFile,fileDirpath,filepath);
        }catch (IOException e){
            return ResultUtils.error(-1,"存储特征失败");
        }
        if (!(re==0)){
            PersonFeature personFeature = new PersonFeature(personId,sequence,filepath);
            return ResultUtils.success(personFeatureRepository.save(personFeature));
        }
        else {
            return ResultUtils.error(-1,"存储特征失败");
        }
    }

    public ResultVO read(Integer personId, String sequence){
        String filepath = personFeatureRepository.findOne(new PersonFeatureKeys(personId,sequence)).getFeaturePath();

        File file = new File(filepath);
        if (file.exists())
        {
            try {
                byte[] bytes = FileStreamUtils.converFileToBytes(file);

                PersonFeature personFeature = new PersonFeature(personId,sequence,filepath);
                return ResultUtils.success(new PersonFeatureDTO(personId,sequence,bytes));
            }
            catch (IOException e){
                return ResultUtils.error(-1,"文件路径正确，但是特征读取失败");
            }
        }
        else {
            return ResultUtils.error(-1,"特征路径输入错误");
        }
    }
}
