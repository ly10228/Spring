package com.ly.spring.bean;

import com.ly.spring.bean.dto.Car;
import com.ly.spring.bean.dto.Person;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author luoyong
 *  * @create 2019-12-07 23:22
 *  * @last modify by [luoyong 2019-12-07 23:22]
 * @Description: BeanCreateTest
 **/
public class BeanCreateTest {

    /**
     * @return void
     * @Description: 传统创建一个对象
     * @author luoyong
     * @create 23:34 2019-12-07
     * @last modify by [LuoYong 23:34 2019-12-07 ]
     */
    @Test
    public void testCommonCreateBean() {
        Person person = new Person();
        person.setName("ly");
        person.sayHello();
    }


    public static void main(String[] args) {

        //1:创建Spring的IOC容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2:从IOC容器当中获取bean的实例
        Person person = (Person) applicationContext.getBean("person");

        //3:调用实例当中的方法
        person.sayHello();

        //构造器注入
        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car.toString());

        //构造方法重载区分
        Car car1 = (Car) applicationContext.getBean("car1");
        System.out.println(car1.toString());

        //给形参赋值存在特殊字符
        Car car2 = (Car) applicationContext.getBean("car2");
        System.out.println(car2.toString());

        //对象的有一个属性类型-->为引用类型
        Person person1 = (Person) applicationContext.getBean("person1");
        System.out.println(person1.toString());


    }
}
