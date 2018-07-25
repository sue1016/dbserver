package com.lab.dbserver.Utils;


import com.lab.dbserver.VO.ResultVO;

public class ResultUtils {
    public static ResultVO success(Object object){
        ResultVO result = new ResultVO();
        result.setCode(0);
        result.setData(object);
        result.setMsg("成功");
        return result;
    }

    public   static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code, String msg){
        ResultVO result = new ResultVO();
        result.setCode(code);
        result.setData(null);
        result.setMsg(msg);
        return result;
    }
}