package com.atguigu.gmallpublisher.service;

import com.atguigu.gmallpublisher.beans.TrafficUvCt;

import java.util.List;

/**
 * 流量域统计接口
 */
public interface TrafficStateService {
    //获取某天各个渠道的独立访客数
    List<TrafficUvCt> getChUvCt(Integer date, Integer limit);
}