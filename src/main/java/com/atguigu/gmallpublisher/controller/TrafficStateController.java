package com.atguigu.gmallpublisher.controller;

import com.atguigu.gmallpublisher.beans.TrafficUvCt;
import com.atguigu.gmallpublisher.service.TrafficStateService;
import com.atguigu.gmallpublisher.utils.DateFormatUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 流量域统计类
 */
@RestController
@RequestMapping("/gmall/realtime/traffic")
public class TrafficStateController {
    @Autowired
    private TrafficStateService trafficStateService;
    @RequestMapping("/ch")
    public String getChUvCt(@RequestParam(value = "date",defaultValue = "0") Integer date,@RequestParam(value = "limit",defaultValue = "10")Integer limit){
        if (date == 0){
            date = DateFormatUtil.now();
        }
        List<TrafficUvCt> chUvCt = trafficStateService.getChUvCt(date, limit);
        List<String> chList = new ArrayList<>();
        List<Integer> uvList = new ArrayList<>();
        for (TrafficUvCt trafficUvCt : chUvCt) {
            chList.add(trafficUvCt.getCh());
            uvList.add(trafficUvCt.getUvCt());
        }
        return "{\n" +
                "  \"status\": 0,\n" +
                "  \"data\": {\n" +
                "    \"categories\": [\"" + StringUtils.join(chList,"\",\"") + "\"],\n" +
                "    \"series\": [\n" +
                "      {\n" +
                "        \"name\": \"独立访客数\",\n" +
                "        \"data\": [" + StringUtils.join(uvList,",") + "]\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";
    }
}
