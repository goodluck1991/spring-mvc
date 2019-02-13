package com.guojun.jiao.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * Created by guojun.jiao on 2019/1/18.
 * 服务器端推送技术
 */
@Controller
public class SseController {

    /**
     * 这里使用输出的媒体类型为text/event-stream,这是服务器端sse的支持
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/push", produces = "text/event-stream")
    public String push(){
        Random random = new Random();
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "data:Testing 1,2,3"+ random.nextInt()+"\n\n";

    }
}
