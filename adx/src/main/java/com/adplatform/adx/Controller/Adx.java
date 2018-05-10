package com.adplatform.adx.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/adx" )
@RestController()
public class Adx {


    @RequestMapping("view")
    public String view(Long id,Long token,Integer adId){
        System.out.println("fff");

        return "success";
    }
}
