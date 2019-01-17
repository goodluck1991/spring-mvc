package com.guojun.jiao.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by guojun.jiao on 2019/1/17.
 * @ControllerAdvice声明一个控制器建言,@ControllerAdvice组合了@Component注解,所以自动注册为Spring的Bean
 */
@ControllerAdvice
public class ExceptionHanderAdvice {

    /**
     * @ExceptionHandler在此处定义全局处理,通过@ExceptionHandler的value属性可过滤拦截的条件
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception e, WebRequest request){
        ModelAndView modelAndView = new ModelAndView("error");//error页面
        modelAndView.addObject("errorMessage",e.getMessage());
        return modelAndView;
    }

    /**
     * @ModelAttribute将键值对添加到全局,所有使用@RequestMapping的方法可获得此键值对
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("msg","other message");
    }

    /**
     * @InitBinder定制WebDataBinder
     * @param webDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        /**
         * 忽略request参数的id
         */
        webDataBinder.setDisallowedFields("id");
    }

}
