package com.guojun.jiao.web;

import com.guojun.jiao.MvcConfig;
import com.guojun.jiao.service.DemoTestService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by guojun.jiao on 2019/2/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class})
//@WebAppConfiguration注解在类上,用来声明加载的AppConfiguration是一个WebAppConfiguration.
//他的属性指定的是web资源的位置,默认为stc/main/webapp,本例修改为src/main/resources
@WebAppConfiguration("src/main/resources")
public class TestControllerIntegrationTests {
    //MockMvc-模拟MVC对象,通过MockMvcBuilders.webAppContextSetup(this.applicationContext).build()初始化
    private MockMvc mockMvc;

    //可以再测试用例中注入Spring的Bean
    @Autowired
    private DemoTestService demoTestService;

    //可注入WebApplicationContext
    @Autowired
    WebApplicationContext applicationContext;

    //可注入模拟的http session,此处仅作演示,没有使用
    @Autowired
    MockHttpSession session;

    //可注入模拟的http request,此处仅作演示,没有使用
    @Autowired
    MockHttpServletRequest request;

    //@Before在测试开始前进行的初始化工作
    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.applicationContext).build();
    }

    @Test
    public void testNormalController()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/normal")).//模拟向/normal进行get请求
                andExpect(MockMvcResultMatchers.status().isOk()).//预期控制返回状态为200
                andExpect(MockMvcResultMatchers.view().name("page")).//预期view的名称为page
                //预期页面转向的真正路径为/WEB-INF/classes/views/page.jsp
                andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/classes/views/page.jsp")).
                //预期model里的值是demoTestService.saySomething()返回值hello
                andExpect(MockMvcResultMatchers.model().attribute("msg",demoTestService.saySomething()));
    }

    @Test
    public void testRestController()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/testRest")).//模拟向/testTest进行get请求
                andExpect(MockMvcResultMatchers.status().isOk()).
                //预期返回值的媒体类型为text/plain;charset=UTF-8
                andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8")).
                //预期返回值的内容为demoTestService.saySomething()返回值hello
                andExpect(MockMvcResultMatchers.content().string(demoTestService.saySomething()));
    }
}
