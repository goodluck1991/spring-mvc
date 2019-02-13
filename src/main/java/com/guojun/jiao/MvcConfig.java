package com.guojun.jiao;

import com.guojun.jiao.interceptor.DemoInterceptor;
import com.guojun.jiao.messageconvert.MyMessageConvert;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

/**
 * Created by guojun.jiao on 2019/1/15.
 * @EnableWebMvc开启SpringMVC支持,若无此句,重写WebMvcConfigurerAdapter方法无效
 */
@Configuration
@EnableWebMvc//开启一些默认配置,如一些ViewResolver或者MessageConverter等
@ComponentScan("com.guojun.jiao")
public class MvcConfig extends WebMvcConfigurerAdapter{

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/classes/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    /**
     * 把拦截器放到springContainer中
     * @return
     */
    @Bean
    public DemoInterceptor demoInterceptor(){
        return new DemoInterceptor();
    }

    /**
     * 增加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }

    /**
     * 可通过重新addViewControllers方法,简化并统一实现静态页面的跳转
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/toUpload").setViewName("/upload");
        registry.addViewController("/converter").setViewName("/converter");
        registry.addViewController("/sse").setViewName("/sse");
    }

    /**
     * Spring MVC中,路径参数如果带"."的话,"."后面的值将被忽略,可以通过重写configurePathMatch方法可不忽略"."后面的参数
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }

    /**
     * addResourceLocations指的是文件放置目录
     * addResourceHandler:对外暴露的访问路径
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    /**
     * 文件上传
     * @return
     */
    @Bean
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1024*5);
        return multipartResolver;
    }


    /**
     * 自定义信息转换器
     * @return
     */
    @Bean
    public MyMessageConvert convert(){
        return new MyMessageConvert();
    }

    /**
     * configureMessageConverters:重载会覆盖掉SpringMVC默认注册的多个HttpMessageConverter
     * extendMessageConverters:仅添加一个自定义的HttpMessageConverter
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(convert());
    }
}
