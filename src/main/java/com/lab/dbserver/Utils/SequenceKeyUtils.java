package com.lab.dbserver.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SequenceKeyUtils {
    //20180723001
    public static String genSequenceKey(Date date,Integer num){
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMDD");
        String d = ft.format(date);
        return d+String.format("%03d",num);
    }
}
