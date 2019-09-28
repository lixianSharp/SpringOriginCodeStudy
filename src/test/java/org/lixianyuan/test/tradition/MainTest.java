package org.lixianyuan.test.tradition;

import org.apache.commons.logging.LogFactory;
import org.lixianyuan.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

/**
 * @Aauthor xianyuan_li@qq.com
 * @Date: Create in 21:33 2019/6/30
 * @Description:
 */
public class MainTest {
    public static void main(String[] args) {
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Person bean = (Person) applicationContext.getBean("person");//从ioc容器中根据bean的id获取bean
        System.out.println(bean);//Person{name='lixianyuan', age=25}
    }
}
