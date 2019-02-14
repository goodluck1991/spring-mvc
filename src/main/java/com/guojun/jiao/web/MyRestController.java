package com.guojun.jiao.web;

import com.guojun.jiao.service.DemoTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by guojun.jiao on 2019/2/14.
 */
@RestController
public class MyRestController {

    @Autowired
    DemoTestService demoTestService;

    @RequestMapping(value = "/testRest",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String testRest(){
        return demoTestService.saySomething();
    }
}
