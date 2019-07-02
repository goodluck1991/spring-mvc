package com.guojun.jiao.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by guojun.jiao on 2019/2/13.
 * 在pushService里产生DeferredResult给控制器使用,通过@Scheduled注解的方法定时更新DeferredResult
 */
@Service
public class PushService {
    //hehehe
    private DeferredResult<String> deferredResult;

    public DeferredResult<String> getAsyncUpdate(){
        deferredResult = new DeferredResult<>();
        return deferredResult;
    }

    @Scheduled(fixedDelay = 5000)
    public void refresh(){
        if(deferredResult != null){
            deferredResult.setResult(new Long(System.currentTimeMillis()).toString());
        }
    }
}
