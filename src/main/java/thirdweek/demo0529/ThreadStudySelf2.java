package thirdweek.demo0529;

/**
 * @author Tiffany_xin
 * @time 2019/5/29  21:26
 */

 class SellTicketDemo2 {
    public static void main(String[] args) {
        // 创建资源对象
        ThreadStudySelf2 st = new ThreadStudySelf2();
        // 创建三个线程对象
        Thread t1 = new Thread(st,"窗口1");
        Thread t2 = new Thread(st,"窗口2");
        Thread t3 = new Thread(st,"窗口3");
        // 启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}

 public class ThreadStudySelf2 implements Runnable{
    //售票案例
    private int tickets = 200;
    private Object object = new Object();
    public void run() {
        while (true) {
            synchronized (ThreadStudySelf2.class){
                if (tickets > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "---" + "正在出售第" + (tickets--) + "张票");
                }
            }
        }
    }
}
