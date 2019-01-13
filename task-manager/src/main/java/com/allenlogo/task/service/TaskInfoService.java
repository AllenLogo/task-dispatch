package com.allenlogo.task.service;

import com.allenlogo.task.vo.request.TIQutaAddReq;
import com.allenlogo.task.vo.request.TITimingAddReq;

/**
 * Created with IntelliJ IDEA.
 *
 * @author allenlogo
 * @Date 2019/1/13
 * @Time 22:41
 * To change this template use File | Settings | File Templates.
 */
public interface TaskInfoService {
    void addTashInfo(TIQutaAddReq tiQutaAddReq);
    void addTashInfo(TITimingAddReq tiTimingAddReqq);
}
