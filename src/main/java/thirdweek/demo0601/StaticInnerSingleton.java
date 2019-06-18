package thirdweek.demo0601;

/**
 * @author Tiffany_xin
 * @time 2019/6/1  14:27
 */
public class StaticInnerSingleton {
    //单例静态内部类式
    private StaticInnerSingleton(){}

    private static class StaticInner{
        private static final StaticInnerSingleton staticInnerSingleton = new StaticInnerSingleton();
    }

    public static final StaticInnerSingleton getInstance(){
        return StaticInner.staticInnerSingleton;
    }


}
