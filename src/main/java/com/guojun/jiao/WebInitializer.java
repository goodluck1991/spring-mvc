package com.guojun.jiao;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

/**
 * Created by guojun.jiao on 2019/1/15.
 * WebApplicationInitializer 是spring提供用来配置Servlet3.0+配置的接口,从而实现代替web.xml的配置,
 * 实现此接口将会自动被SpringServletContainerInitializer(用来启动Servlet3.0容器)获取到
 */
public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //新建WebApplicationContext,注册配置类,并将其和当前servletContext关联
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(MvcConfig.class);
        context.setServletContext(servletContext);
        //注册SpringMVC的DispatcherServlet
        Dynamic dynamic = servletContext.addServlet("dispatcher",new DispatcherServlet(context));
        dynamic.addMapping("/");
        dynamic.setLoadOnStartup(1);
        dynamic.setAsyncSupported(true);//开启异步方法支持
    }
}
