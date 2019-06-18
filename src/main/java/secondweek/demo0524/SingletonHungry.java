package secondweek.demo0524;

/**
 * @author Tiffany_xin
 * @time 2019/5/24  21:43
 */
public class SingletonHungry {
    //饿汉式: 不用考虑多线程,缺点可能会造成资源的浪费!
    private static SingletonHungry singletonHungry = new SingletonHungry();
    private SingletonHungry(){}
    public static SingletonHungry getInstance(){
        return singletonHungry;
    }
}
