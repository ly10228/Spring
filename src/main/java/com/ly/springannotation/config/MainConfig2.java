package com.ly.springannotation.config;

import com.ly.springannotation.bean.Person;
import com.ly.springannotation.condition.LinuxCondition;
import com.ly.springannotation.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * @author luoyong
 * @Description: MainConfig2
 * @create 2019-12-28 22:38
 * @last modify by [LuoYong 2019-12-28 22:38]
 **/
@Conditional({WindowsCondition.class})
@Configuration
public class MainConfig2 {

    /**
     * @param
     * @return
     * @Description: @Scope 作用域
     * prototype：多实例的：ioc容器启动并不会去调用方法创建对象放在容器中。每次获取的时候才会调用方法创建对象；
     * singleton：单实例的（默认值）：ioc容器启动会调用方法创建对象放到ioc容器中。以后每次获取就是直接从容器（map.get()）中拿，
     * request：同一次请求创建一个实例
     * session：同一个session创建一个实例
     * @author luoyong
     * @create 22:48 2019/12/28
     * @last modify by [LuoYong 22:48 2019/12/28 ]
     */
    @Bean
//    @Scope("prototype")
    @Scope
    /**
     * 懒加载：针对于单实例bean
     * 单实例bean：默认在容器启动的时候创建对象
     * 懒加载：容器启动之后不创建对象，第一使用（获取时）Bean时才去创建对象，并进行初始化
     */
    @Lazy
    public Person person() {
        System.out.println("往容器当中添加Person....");
        return new Person("张三", 25);
    }


    /**
     * @Conditional({Condition}) ： 按照一定的条件进行判断，满足条件给容器中注册bean
     * <p>
     * 如果系统是windows，给容器中注册("bill")
     * 如果是linux系统，给容器中注册("linus")
     */
    @Conditional(WindowsCondition.class)
    @Bean("bill")
    public Person person01() {
        return new Person("Bill Gates", 62);
    }

    @Conditional(LinuxCondition.class)
    @Bean("linus")
    public Person person02() {
        return new Person("linus", 66);
    }
}
