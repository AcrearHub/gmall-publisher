package com.atguigu.gmallpublisher.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor //不能有无参构造器
public class TradeProvinceOrderAmount {
    //省份名称
    String provinceOrderName;
    //下单金额
    Double orderAmount;
}
