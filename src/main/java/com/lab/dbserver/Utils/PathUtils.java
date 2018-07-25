package com.lab.dbserver.Utils;

public class PathUtils {
    public static String genPicFeaturePath(Integer frame,Integer cameraId,String sequenceId){
        return "./data/"+"PicFeatures/"+sequenceId+"/"+String.valueOf(cameraId)+"/"+String.valueOf(frame)+".mat";
    }

    public static String genPicFeatureDirPath(Integer cameraId,String sequenceId){
        return "./data/"+"PicFeatures/"+sequenceId+"/"+String.valueOf(cameraId);
    }

    public static String genPersonFeaturePath(Integer personId,String sequenceId){
        return "./data/"+"PersonFeatures/"+sequenceId+"/"+String.valueOf(personId)+".mat";
    }

    public static String genPersonFeatureDirPath(String sequenceId){
        return "./data/"+"PersonFeatures/"+sequenceId;
    }

    public static String genPicturePath(Integer frame,Integer cameraId,String sequenceId){
        return "./data/"+"Pictures/"+sequenceId+"/"+String.valueOf(cameraId)+"/"+String.valueOf(frame)+".mat";
    }

    public static String genPictureDirPath(Integer cameraId,String sequenceId){
        return "./data/"+"Pictures/"+sequenceId+"/"+String.valueOf(cameraId);
    }
}
