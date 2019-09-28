package org.lixianyuan.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;


import java.io.IOException;

/**
 * @Aauthor xianyuan_li@qq.com
 * @Date: Create in 22:38 2019/6/30
 * @Description: 自定义规则，实现TypeFilter接口
 */
public class MyTypeFilter implements TypeFilter {

    /**
     * @param metadataReader        读取到的当前正在扫描的类的信息
     * @param metadataReaderFactory 可以获取到其他任何类信息的(也就是自己写的任何类咯，也叫自己自定义的类)
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类 注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描的 类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类资源(类的路径)
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        System.out.println("--->" + className);//打印被扫描的类的全限定名，但在此处还并未加入到ioc，容器中，只是被扫描。
        /**
         --->org.lixianyuan.test.annotation.MainTest
         --->org.lixianyuan.test.tradition.MainTest
         --->org.lixianyuan.bean.Person  这是通过@Bean注入到ioc容器中的
         --->org.lixianyuan.config.MyTypeFilter
         --->org.lixianyuan.controller.BookController
         --->org.lixianyuan.dao.BookDao
         --->org.lixianyuan.service.BookService
         */
        //如果是包含"er"的类，则加入到IOC容器中，否则不加入到IOC容器中。
        if(className.contains("er")) {
            return true;//返回true表示加入到ioc容器中。
        }else{
            return false;//返回false表示不加入到ioc容器中
        }

    }

}
