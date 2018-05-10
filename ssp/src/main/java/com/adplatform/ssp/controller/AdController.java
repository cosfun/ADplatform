package com.adplatform.ssp.controller;

import com.adplatform.ssp.constants.Constants;
import com.adplatform.ssp.dao.AdInfoMapper;
import com.adplatform.ssp.dao.SspMapper;
import com.adplatform.ssp.pojo.AdInfo;
import com.adplatform.ssp.pojo.Ssp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/ad")
@RestController
public class AdController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    SspMapper sspMapper;

    @Autowired
    AdInfoMapper adInfoMapper;

    @RequestMapping(value = "view", method = RequestMethod.GET)
    public String newAd(Long sspId, String sspToken, Long adId) {
        if (sspId == null || sspToken == null || adId == null) {
            return "参数错误";
        }

        Ssp ssp = sspMapper.selectByPrimaryKey(sspId);
        if (ssp == null || !ssp.getToken().equals(sspToken)) {
            return "token错误";
        }

        AdInfo adInfo = adInfoMapper.selectByPrimaryKey(adId);
        if (adInfo == null) {
            return "adInfo不存在";
        }
        if (!adInfo.getId().equals(sspId)) {
            return "ssp id不对应";
        }
        System.out.println("url:" + Constants.AdxUrl);

        Map<String, String> data = new HashMap<>();
        data.put("id", ssp.getAdxId());
        data.put("token", ssp.getAdxToken());
        data.put("adId", adInfo.getAdxAdId()+"");
        restTemplate.getForObject(Constants.AdxUrl, String.class, data);
        return "success";
    }
}
