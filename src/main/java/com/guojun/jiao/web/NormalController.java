package com.guojun.jiao.web;

import com.guojun.jiao.service.DemoTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by guojun.jiao on 2019/2/14.
 */
@Controller
public class NormalController {

    @Autowired
    DemoTestService demoTestService;

    @RequestMapping("/normal")
    public String testPage(Model model){
        model.addAttribute("msg",demoTestService.saySomething());
        return "page";
    }
}
