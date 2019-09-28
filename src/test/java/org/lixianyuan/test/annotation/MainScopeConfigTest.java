package org.lixianyuan.test.annotation;

import org.junit.Test;
import org.lixianyuan.config.MainScopeConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Aauthor xianyuan_li@qq.com
 * @Date: Create in 21:32 2019/7/1
 * @Description:
 */
public class MainScopeConfigTest {

    //没有加@Scope(scopeName="prototype")的时候
    @Test
    public void Test01(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainScopeConfig.class);
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        //获取容器中所有bean的名字(也就是已经注入到了ioc容器中的bean的名字)
        for(String name:beanNames){
            System.out.println(name);
        }
        System.out.println("ioc容器创建完成");

        Object bean = applicationContext.getBean("person");
        Object bean2 = applicationContext.getBean("person");
        System.out.println(bean==bean2);//true,说明是同一个对象，单例
        /**
         * 打印结果：
         给容器中添加Person....
         org.springframework.context.annotation.internalConfigurationAnnotationProcessor
         org.springframework.context.annotation.internalAutowiredAnnotationProcessor
         org.springframework.context.annotation.internalRequiredAnnotationProcessor
         org.springframework.context.annotation.internalCommonAnnotationProcessor
         org.springframework.context.event.internalEventListenerProcessor
         org.springframework.context.event.internalEventListenerFactory
         mainScopeConfig
         person
         ioc容器创建完成
         true
         */
    }

    //只加了@Scope(scopeName="prototype")的时候
    @Test
    public void Test02(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainScopeConfig.class);
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        //获取容器中所有bean的名字(也就是已经注入到了ioc容器中的bean的名字)
        for(String name:beanNames){
            System.out.println(name);
        }
        System.out.println("ioc容器创建完成");

        Object bean = applicationContext.getBean("person");
        Object bean2 = applicationContext.getBean("person");
        System.out.println(bean==bean2);//false,说明不是同一个对象，多例模式。
        //(多实例的时候，ioc容器启动并不会去调用方法创建对象放在容器中。每次获取的时候才会调用方法创建对象。):
        /**
         * org.springframework.context.annotation.internalConfigurationAnnotationProcessor
         * org.springframework.context.annotation.internalAutowiredAnnotationProcessor
         * org.springframework.context.annotation.internalRequiredAnnotationProcessor
         * org.springframework.context.annotation.internalCommonAnnotationProcessor
         * org.springframework.context.event.internalEventListenerProcessor
         * org.springframework.context.event.internalEventListenerFactory
         * mainScopeConfig
         * person
         * ioc容器创建完成
         * 给容器中添加Person....
         * 给容器中添加Person....
         * false
         */
    }

    //测试@Lazy-bean懒加载，没有放开@Lazy懒加载注释的时候
    @Test
    public void Test03(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainScopeConfig.class);

        System.out.println("ioc容器创建完成");
        /**
         * 打印结果：
                给容器中添加Person....
                ioc容器创建完成
         */
    }

    //加上了@Lazy 的时候(懒加载是针对单实例的，懒加载只有当对象被使用的时候才从容器中获取。)
    @Test
    public void Test04(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainScopeConfig.class);

        System.out.println("ioc容器创建完成");
        /**
         * 打印结果：
              ioc容器创建完成
         */
    }


}
