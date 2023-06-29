package com.atguigu.gmallpublisher.service.Impl;

import com.atguigu.gmallpublisher.beans.TradeProvinceOrderAmount;
import com.atguigu.gmallpublisher.mapper.TradeStateMapper;
import com.atguigu.gmallpublisher.service.TradeStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 交易域统计实现类
 */
@Service
public class TradeStateServiceImpl implements TradeStateService {
    @Autowired  //把spring容器中类的对象赋值到这里
    private TradeStateMapper tradeStateMapper;
    @Override
    public BigDecimal getGMV(Integer date) {
        return tradeStateMapper.selectGMV(date);
    }

    @Override
    public List<TradeProvinceOrderAmount> getProvinceAmount(Integer date) {
        return tradeStateMapper.selectProvinceAmount(date);
    }
}
