package com.guojun.jiao.web;

import com.guojun.jiao.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by guojun.jiao on 2019/1/17.
 */
@Controller
@RequestMapping("anno")
public class DemoAnnoController {

    @ResponseBody
    @RequestMapping(produces = "text/plain;charset=UTF-8")
    public String index(HttpServletRequest request){
        return "url:"+request.getRequestURL()+" can access";

    }

    @ResponseBody
    @RequestMapping(value = "/pathvar/{str}",produces = "text/plain;charset=UTF-8")
    public String demoPathVar(@PathVariable String str,HttpServletRequest request){
        return "url:"+request.getRequestURL()+" can access,str:"+str;
    }

    @ResponseBody
    @RequestMapping(value = "/requestParam",produces = "text/plain;charset=UTF-8")
    public String passRequestParam(Long id,HttpServletRequest request){
        return "url:"+request.getRequestURL()+" can access,id:"+id;
    }

    @ResponseBody
    @RequestMapping(value = "/obj",produces = "application/json;charset=UTF-8")
    public String passObj(DemoObj demoObj,HttpServletRequest request){
        return "url:"+request.getRequestURL()+" can access,obj.id:"+demoObj.getId()+" demoObj.name:"+demoObj.getName();
    }

    @ResponseBody
    @RequestMapping(value = {"/name1","/name2"},produces = "text/plain;charset=UTF-8")
    public String remove(HttpServletRequest request){
        return "url:"+request.getRequestURL()+" can access";
    }
}
