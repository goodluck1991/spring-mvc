package com.guojun.jiao.web;

import com.guojun.jiao.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by guojun.jiao on 2019/1/17.
 */
@Controller
public class AdviceController {

    @RequestMapping("advice")
    public String getSomething(@ModelAttribute("msg") String msg, DemoObj obj){
        throw new IllegalArgumentException("Sorry,param is error,from @ModelAttribute:"+msg);
    }
}
