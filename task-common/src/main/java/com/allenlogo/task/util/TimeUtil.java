package com.allenlogo.task.util;

import javax.validation.constraints.NotNull;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间处理工具
 */
public class TimeUtil {
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取当前时间的输入格式
     * @param sdf 格式
     * @return
     */
    public static String getCurrentTime(@NotNull SimpleDateFormat sdf) {
        return sdf.format(new Date());
    }

    /**
     * 获取输入时间的输入格式
     * @param sdf
     * @param data
     * @return
     */
    public static String getTimeSDF(@NotNull SimpleDateFormat sdf, Date data) {
        return data==null?"":sdf.format(data);
    }

}
