package com.guojun.jiao.domain;

/**
 * Created by guojun.jiao on 2019/1/17.
 */
public class DemoObj {
    private Long id;
    private String name;

    public DemoObj() {//jackson对对象和json做转换时一定需要空构造器
    }

    public DemoObj(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
