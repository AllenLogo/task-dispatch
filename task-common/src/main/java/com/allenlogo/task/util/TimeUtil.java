package com.allenlogo.task.util;

import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间处理工具
 */
public class TimeUtil {
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 过去当前时间的输入格式
     * @param sdf 格式
     * @return
     */
    public static String getCurrentTime(@NotNull SimpleDateFormat sdf) {
        return sdf.format(new Date());
    }

}
