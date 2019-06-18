package fiveweek.demo0614;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Tiffany_xin
 * @time 2019/6/14  18:58
 */
public class EatInvocationHandler implements InvocationHandler {
    private Object target;

    public EatInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理的操作,吃饭先洗手");
        return method.invoke(target, args);
    }
}
