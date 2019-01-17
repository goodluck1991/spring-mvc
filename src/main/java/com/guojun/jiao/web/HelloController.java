package com.guojun.jiao.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by guojun.jiao on 2019/1/17.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/index")
    public String index(){
        return "index";//通过上面ViewResolver的Bean配置,返回值为index,说明我们的页面放置的路径为/WEB-INF/classes/views/index.jsp
    }
}
