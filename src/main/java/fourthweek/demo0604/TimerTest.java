package fourthweek.demo0604;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Tiffany_xin
 * @time 2019/6/4  14:23
 */
public class TimerTest {
    public static void main(String[] args) throws Exception {

        //普通线程的调度器
//        Timer timer = new Timer();
//        timer.schedule(new MyThread(),3000,2000);
//
//        //线程池
//        ExecutorService pool = Executors.newFixedThreadPool(2);
//        pool.submit(new MyThread());
//        pool.submit(new MyThread());
//        pool.shutdown();

        //线程池调度器
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(2);
        scheduledPool.schedule(new MyThread1(),2, TimeUnit.SECONDS);
        //控制线程池里子线程的执行顺序吧
        scheduledPool.awaitTermination(5,TimeUnit.SECONDS);
        scheduledPool.schedule(new MyThread(),2, TimeUnit.SECONDS);
//        scheduledPool.shutdown();
//        scheduledPool.scheduleAtFixedRate(new MyThread(),1,2,TimeUnit.SECONDS);
//        scheduledPool.scheduleAtFixedRate(new MyThread(),2,2,TimeUnit.SECONDS);
//        scheduledPool.shutdown();




    }
}


class MyThread extends TimerTask {
    @Override
    public void run() {
        for (int i=0 ; i<10; i++){
            System.out.println("炸弹");
        }
    }
}

class MyThread1 extends TimerTask {
    @Override
    public void run() {
        for (int i=0 ; i<10; i++){
            System.out.println("炸弹1");
        }
    }
}


