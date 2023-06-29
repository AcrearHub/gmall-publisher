package com.atguigu.gmallpublisher.service.Impl;

import com.atguigu.gmallpublisher.beans.TrafficUvCt;
import com.atguigu.gmallpublisher.mapper.TrafficStateMapper;
import com.atguigu.gmallpublisher.service.TrafficStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 流量域统计实现类
 */
@Service
public class TrafficStateServiceImpl implements TrafficStateService {
    @Autowired
    private TrafficStateMapper trafficStateMapper;

    @Override
    public List<TrafficUvCt> getChUvCt(Integer date, Integer limit) {
        return trafficStateMapper.selectChUvCt(date,limit);
    }
}
