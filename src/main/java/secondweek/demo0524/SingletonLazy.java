package secondweek.demo0524;

/**
 * @author Tiffany_xin
 * @time 2019/5/24  21:46
 */
public class SingletonLazy {


    //懒汉式: 双重锁,避免多线程问题,避免资源浪费
    //缺点:双重锁降低了程序响应速度和性能
    private static volatile SingletonLazy singletonLazy;
    private SingletonLazy(){}

    public static SingletonLazy getInstance(){
        if (singletonLazy == null){
            synchronized(SingletonLazy.class){
                if (singletonLazy == null){
                    singletonLazy = new SingletonLazy();
                }
            }
        }
        return singletonLazy;
    }
}
