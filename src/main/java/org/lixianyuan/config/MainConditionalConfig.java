package org.lixianyuan.config;

import org.lixianyuan.bean.Person;
import org.lixianyuan.condition.LinuxCondition;
import org.lixianyuan.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Aauthor xianyuan_li@qq.com
 * @Date: Create in 22:03 2019/7/1
 * @Description: @Conditional-按照条件注册bean
 */
//类中组件统一设置。@Conditional标记在类上，表示：满足当前条件，这个类(也就是指MainConditionalConfig这个配置类)中配置的所有bean注册才能生效。
//@Conditional({LinuxCondition.class}) //如果配置类为LinuxCondition.class 则在windows环境中当前配置类MainConditionalConfig中配置的所有bean都不会被注册到ioc容器中
@Configuration //告诉Spring，这是一个配置类
public class MainConditionalConfig {

    @Bean(name="person") ////表示id设置为person,不使用id默认是方法名的方式
    public Person person(){
        System.out.println("给容器中添加Person...");
        return new Person("张三",36);
    }

    //参数WindowsCondition.class表示判断条件在WindowsCondition中。WindowsCondition必须要实现spring中注解的Condition接口。
    @Conditional({WindowsCondition.class})//@Conditional标记在方法上，表示当前的@Bean按照条件判断.
    @Bean(name="bill")
    public Person person01(){
        return new Person("Bill Gates",63);
    }


    @Conditional({LinuxCondition.class})//@Conditional标记在方法上，表示当前的@Bean按照条件判断
    @Bean(name="linus")
    public Person person02(){
        return new Person("linus",48);
    }

}

