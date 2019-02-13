package com.guojun.jiao.web;

import com.guojun.jiao.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by guojun.jiao on 2019/2/13.
 * 异步任务的实现是通过控制器从另外一个线程返回一个DeferredResult,这里的DeferredResult是从pushService中获取的
 */
@Controller
public class AysncController {
    @Autowired
    PushService pushService;//定时任务,定时更新DeferredResult

    @RequestMapping("defer")
    @ResponseBody
    public DeferredResult<String> deferredCall(){//返回客户DeferredResult
        return pushService.getAsyncUpdate();
    }
}
