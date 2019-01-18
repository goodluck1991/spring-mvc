package com.guojun.jiao.web;

import com.guojun.jiao.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by guojun.jiao on 2019/1/18.
 */
@Controller
public class ConverterController {

    @ResponseBody
    @RequestMapping(value = "/convert", produces = {"application/x-wisely"})//指定返回的媒体类型为我们自定义的媒体类型application/x-wisely
    public DemoObj convert(@RequestBody DemoObj demoObj){
        return demoObj;
    }

}
