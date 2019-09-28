package org.lixianyuan.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.lang.annotation.Annotation;

/**
 * @Aauthor xianyuan_li@qq.com
 * @Date: Create in 22:09 2019/7/1
 * @Description: 实现spring 注解中的Condition接口
 */
//判断是否是windows系统
public class WindowsCondition implements Condition {

    /**
     * @param conditionContext      判断条件能使用的上下文(环境)
     * @param annotatedTypeMetadata 注解信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //是否是windows系统
        //1、获取到ioc使用的beanfactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //2、获取类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        //3、获取当前环境信息
        Environment environment = conditionContext.getEnvironment();
        //4、获取到bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();
        // 从当前环境信息中获取操作系统的名字
        String property = environment.getProperty("os.name");
        //如果是windows，则加入到ioc容器中
        if(property.toLowerCase().contains("windows")){
            return true;
        }
        return false;
    }
}
