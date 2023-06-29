package com.atguigu.gmallpublisher.mapper;

import com.atguigu.gmallpublisher.beans.TradeProvinceOrderAmount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

/**
 * 交易域统计接口
 */
@Mapper
public interface TradeStateMapper {
    //获取某天总交易额，@Insert、@Delete、@Update、@Select：通过JDBC将crud封装到方法中
    @Select("select sum(order_amount) order_amount from dws_trade_province_order_window where toYYYYMMDD(stt)=#{date}")
    BigDecimal selectGMV(@Param("date") Integer date);  //当只有一个参数时@Param可不加

    //获取某天各个省份交易额
    @Select("select province_name,sum(order_amount) order_amount from dws_trade_province_order_window where toYYYYMMDD(stt)=#{date} group by province_name")
    List<TradeProvinceOrderAmount> selectProvinceAmount(@Param("date") Integer date);
}
