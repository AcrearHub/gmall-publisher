package com.atguigu.gmallpublisher.controller;

import com.atguigu.gmallpublisher.beans.TradeProvinceOrderAmount;
import com.atguigu.gmallpublisher.service.TradeStateService;
import com.atguigu.gmallpublisher.utils.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * 交易域统计类
 */
@RestController //将对象的创建交给spring容器，若返回值为String，处理完毕后页面不会跳转到String（@Controller则会跳转），将数据以String形式返回给客户端
@RequestMapping("/gmall/realtime/trade")
public class TradeStateController {
    @Autowired
    private TradeStateService tradeStateService;
    @RequestMapping("/gmv")
    public String getGMV(@RequestParam(value = "date",defaultValue = "0") Integer date) {
        if (date == 0){
            date = DateFormatUtil.now();
        }
        BigDecimal gmv = tradeStateService.getGMV(date);
        return "{\n" +
                "  \"status\": 0,\n" +
                "  \"data\": "+ gmv +"\n" +
                "}";
    }

    @RequestMapping("/province")
    public String getProvinceAmount(@RequestParam(value = "date", defaultValue = "0") Integer date){
        if (date == 0){
            date = DateFormatUtil.now();
        }
        List<TradeProvinceOrderAmount> provinceAmount = tradeStateService.getProvinceAmount(date);
        StringBuilder sb = new StringBuilder("{\n" +
                "        \"status\": 0,\n" +
                "        \"msg\": \"\",\n" +
                "        \"data\": {\n" +
                "        \"mapData\": [");
        for (int i = 0; i < provinceAmount.size(); i++) {
            TradeProvinceOrderAmount tradeProvinceOrderAmount = provinceAmount.get(i);
            sb.append("{\"name\": \"" + tradeProvinceOrderAmount.getProvinceOrderName() + "\",\"value\": " + tradeProvinceOrderAmount.getOrderAmount() + "}");
            if (i < provinceAmount.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("],\n" +
                "        \"valueName\": \"交易额\"\n" +
                "        }\n" +
                "        }");
        return sb.toString();
    }
}
