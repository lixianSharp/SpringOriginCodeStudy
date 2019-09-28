package org.lixianyuan.test.annotation;

import javafx.application.Application;
import org.junit.Test;
import org.lixianyuan.bean.Person;
import org.lixianyuan.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Aauthor xianyuan_li@qq.com
 * @Date: Create in 22:02 2019/6/30
 * @Description: 测试通过使用@Configuration和@Bean给容器中注册组件，从容器中获取bean
 */
public class MainTest {
    public static void main(String[] args) {
        //读取配置类MainConfig
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        //获取配置类MainConfig中注入的bean
        Person bean = (Person) applicationContext.getBean(Person.class);
        //打印出来的是通过@Configuration和@Bean给容器中注入的那个bean
        System.out.println(bean);//Person{name='李贤元', age=24}

        //获取bean的名字(就是@Bean(name="person1")中name的值"person1")
        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        for(String name:namesForType) {
            System.out.println(name);//person1
        }
    }

    //ComponentScan自动组件扫描的第一种情况
    @Test
    public void test1() {
        //获取配置类MainConfig
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        //获取容器中所有bean的名字(也就是已经注入到IOC容器中了的bean的名字。默认是首字母小写的)
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:definitionNames){
            System.out.println(name);
        }

       /*
       打印结果：
        org.springframework.context.annotation.internalConfigurationAnnotationProcessor
        org.springframework.context.annotation.internalAutowiredAnnotationProcessor
        org.springframework.context.annotation.internalRequiredAnnotationProcessor
        org.springframework.context.annotation.internalCommonAnnotationProcessor
        org.springframework.context.event.internalEventListenerProcessor
        org.springframework.context.event.internalEventListenerFactory
        mainConfig
        org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor
        org.springframework.context.annotation.ConfigurationClassPostProcessor.enhancedConfigurationProcessor
        bookDao
        person1
        */
    }


    //ComponentScan自动组件扫描的第二种情况
    @Test
    public void test2() {
        //获取配置类MainConfig
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        //获取容器中所有bean的名字(也就是已经注入到IOC容器中了的bean的名字。默认是首字母小写的)
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:definitionNames){
            System.out.println(name);
        }
    }

    //ComponentScan自动组件扫描的第3种情况
    @Test
    public void test3() {
        //获取配置类MainConfig
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        //获取容器中所有bean的名字(也就是已经注入到IOC容器中了的bean的名字。默认是首字母小写的)
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:definitionNames){
            System.out.println(name);
        }
    }


    //ComponentScan自动组件扫描的第4种情况
    @Test
    public void test4() {
        //获取配置类MainConfig
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        //获取容器中所有bean的名字(也就是已经注入到IOC容器中了的bean的名字。默认是首字母小写的)
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:definitionNames){
            System.out.println(name);
        }
        /**
         打印结果：
         org.springframework.context.annotation.internalConfigurationAnnotationProcessor
         org.springframework.context.annotation.internalAutowiredAnnotationProcessor
         org.springframework.context.annotation.internalRequiredAnnotationProcessor
         org.springframework.context.annotation.internalCommonAnnotationProcessor
         org.springframework.context.event.internalEventListenerProcessor
         org.springframework.context.event.internalEventListenerFactory
         mainConfig   //因为这是配置类，所以必须要有啊
         org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor
         org.springframework.context.annotation.ConfigurationClassPostProcessor.enhancedConfigurationProcessor
         person  //这是通过bean.xml注入到ioc容器中的
         myTypeFilter
         bookController
         bookService
         person1  //这是通过@Bean注入到ioc容器中的
         */
    }
}
