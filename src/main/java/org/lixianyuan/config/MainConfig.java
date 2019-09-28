package org.lixianyuan.config;

import org.lixianyuan.bean.Person;
import org.lixianyuan.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @Aauthor xianyuan_li@qq.com
 * @Date: Create in 21:43 2019/6/30
 * @Description: 组件注册，通过使用@Configuration和@Bean给容器中注册组件
 */

/**
 //第一种情况
 @ComponentScan(value={"org.lixianyuan"},excludeFilters = {
     @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = {Controller.class, Service.class})
 })///包扫描  不扫描org.lixianyuan包下带有Controller、Service的注解


 */

//第二种情况
/**
 @ComponentScan(value = {"org.lixianyuan"},includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
},useDefaultFilters = false)*///包扫描  只扫描com.atguigu包下带有Controller注解的

/**
//第三种情况：
@ComponentScan(value="org.lixianyuan",includeFilters= {
		@Filter(type=FilterType.ASSIGNABLE_TYPE,classes= {BookService.class}),//按照给定的类型扫描 //表示BookService类型的也可以被扫描，该类及其子类或实现类
})
*/

//第四种情况
@ComponentScan(value = "org.lixianyuan",includeFilters = {
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})//自定义规则
},useDefaultFilters = false)//useDefaultFilters=false表示关闭默认的过滤规则
//@ComponentScan value:指定要扫描的包
//  excludeFilters=Filter[] :指定扫描的时候按照什么规则排除哪些组件
//  includeFilters=Filter[] ：指定扫描的时候只需要包含哪些组件
// FilterType.ANNOTATION :按照注解
// FilterType.ASSIGNABLE_TYPE :按照给定的类型
// FilterType.ASPECTJ ：使用ASPECTJ表达式
// FilterType.REGEX :使用正则表达式
// FilterType.CUSTOM :适用自定义规则


//配置类<==>等价于以前Spring中的配置文件bean.xml
@Configuration //告诉Spring这是一个配置类
public class MainConfig {

    //给容器中注册一个Bean；类型为返回值类型，id默认是方法名作为id
    @Bean(name="person1")
    public Person person01(){
        return new Person("李贤元",24);
    }
}
