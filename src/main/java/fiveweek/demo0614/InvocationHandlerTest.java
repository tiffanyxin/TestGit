package fiveweek.demo0614;

import java.lang.reflect.Proxy;

/**
 * @author Tiffany_xin
 * @time 2019/6/14  19:04
 */
public class InvocationHandlerTest {
    public static void main(String[] args) {
        //定义被代理对象
        Eat eat = new Person();

        //生成调用处理器
        EatInvocationHandler h = new EatInvocationHandler(eat);

        //3.生成动态代理
        Eat proxy = (Eat) Proxy.newProxyInstance(Person.class.getClassLoader(),
                Person.class.getInterfaces(), h);

        //调用动态代理
        proxy.eat();


    }
}
