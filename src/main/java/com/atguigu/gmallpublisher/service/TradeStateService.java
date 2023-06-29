package com.atguigu.gmallpublisher.service;

import com.atguigu.gmallpublisher.beans.TradeProvinceOrderAmount;

import java.math.BigDecimal;
import java.util.List;

/**
 * 交易域统计接口
 */
public interface TradeStateService {
    //获取某天总交易额
    BigDecimal getGMV(Integer date);

    //获取某天各个省份交易额
    List<TradeProvinceOrderAmount> getProvinceAmount(Integer date);
}
