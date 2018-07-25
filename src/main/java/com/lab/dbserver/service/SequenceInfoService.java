package com.lab.dbserver.service;

import com.lab.dbserver.Utils.ResultUtils;
import com.lab.dbserver.Utils.SequenceKeyUtils;
import com.lab.dbserver.VO.ResultVO;
import com.lab.dbserver.dataobject.SequenceInfo;
import com.lab.dbserver.repository.SequenceInfoReposity;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class SequenceInfoService {

    @Autowired
    SequenceInfoReposity sequenceInfoReposity;

    /**
     * 增加一条视频序列
     */
    public ResultVO create(Date startDate,Date finishDate){
        SequenceInfo sequenceInfo = new SequenceInfo();
        sequenceInfo.setStartDate(startDate);
        sequenceInfo.setFinishDate(finishDate);

        //计算这一天中有多少序列
        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        c.set(c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH));

        Calendar c1 = Calendar.getInstance();
        c1.setTime(c.getTime());
        c1.add(Calendar.DAY_OF_MONTH,1);
        List<SequenceInfo> seqToday = sequenceInfoReposity.findByStartDateBetween(c.getTime(),c1.getTime());
        int num = seqToday.size();

        String keys = SequenceKeyUtils.genSequenceKey(c.getTime(),num+1);

        sequenceInfo.setSequenceId(keys);
        return ResultUtils.success(sequenceInfoReposity.save(sequenceInfo));
    }
}
