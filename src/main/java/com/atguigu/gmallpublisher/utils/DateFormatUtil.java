package com.atguigu.gmallpublisher.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * 日期处理
 */
public class DateFormatUtil {
    public static Integer now() {
        String date = DateFormatUtils.format(new Date(),"yyyyMMdd");
        return Integer.parseInt(date);
    }
}
