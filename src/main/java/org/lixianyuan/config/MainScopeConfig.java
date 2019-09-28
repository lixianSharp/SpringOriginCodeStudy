package org.lixianyuan.config;

import org.lixianyuan.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * @Aauthor xianyuan_li@qq.com
 * @Date: Create in 21:31 2019/7/1
 * @Description: @Scope-设置组件作用域  和  @Lazy-bean懒加载
 */
@Configuration //表示这是一个配置类
public class MainScopeConfig {

    /**
         @see ConfigurableBeanFactory#SCOPE_PROTOTYPE  prototype
         @see ConfigurableBeanFactory#SCOPE_SINGLETON  singleton
         @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST  request
         @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION  session
     * @Scope:调整作用域
     *  prototype:多实例的；ioc容器启动并不会去调用方法创建对象放在容器中。
     * 					每次获取的时候才会调用方法创建对象。
     *  singleton：单实例的(默认值);IOC容器启动会调用方法创建对象放到IOC容器中。
     * 					以后每次获取就是直接从容器(map.get())中拿。
     *  request:同义词请求创建一个实例
     *  session:同一个session创建一个实例
     * 懒加载：(懒加载是针对单实例的)
     * 		单实例bean：默认在容器启动的时候创建对象；
     * 		懒加载：容器启动不创建对象。第一次使用(获取)Bean创建对象，并初始化；
     */
    @Lazy//该注释表示当前的这个bean(就是name="person")的这个bean是否要进行懒加载
    //@Scope(scopeName="prototype")
    @Bean(name="person") // @Bean 给容器中注入一个bean id名字为"person"。表示id设置为person,不使用id默认是方法名的方式
    public Person person(){
        System.out.println("给容器中添加Person....");
        return new Person("张三",25);
    }
}
