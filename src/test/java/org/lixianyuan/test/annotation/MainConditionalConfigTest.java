package org.lixianyuan.test.annotation;

import org.lixianyuan.config.MainConditionalConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Aauthor xianyuan_li@qq.com
 * @Date: Create in 22:21 2019/7/1
 * @Description:
 */
public class MainConditionalConfigTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConditionalConfig.class);
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for(String name:beanNames){
            System.out.println(name);
        }
    }
}
