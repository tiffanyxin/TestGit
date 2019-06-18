package thirdweek.demo0529;

/**
 * @author Tiffany_xin
 * @time 2019/5/28  10:37
 */
public class ThreadStudySelf1 {
    public static void main(String[] args) {



        //获取当前执行的线程,所以可以调用getName(),setName()方法
//        System.out.println(Thread.currentThread());

//        MyThread2 my = new MyThread2("MyThread");
        //普通调用
//        my.run();
        //线程启动
//        my.start();


        //需要重写run方法,不然start后调用run没有任何执行;
        // 根据构造函数,所以有两种创建线程的方式出来
//        Thread t = new Thread();
//        t.start();

        //第一种创建线程的方法:
//        MyThread2 my1 = new MyThread2();
//        MyThread2 my2 = new MyThread2();

//        my1.setName("林青霞");
//        my2.setName("刘意");
//        my1.start();
//        my2.start();
//        System.out.println(Thread.currentThread().getName());   //main

        //第二种创建线程的方法:
//       MyThread3 my3 = new MyThread3();
//       Thread runnableThread = new Thread(my3,"hehe");
//       runnableThread.start();

        //设置调度优先级
//        MyThread2 my5 = new MyThread2();
//        System.out.println(my5.getPriority());

        //测试join加入线程:
//        ThreadJoin tj1 = new ThreadJoin();
//        ThreadJoin tj2 = new ThreadJoin();
//        ThreadJoin tj3 = new ThreadJoin();
//        tj1.setName("李渊");
//        tj2.setName("李世民");
//        tj3.setName("李元霸");
//        tj1.start();
//        try {
//            //等待tj1线程执行完毕,才会往下执行其它线程或者main线程
//            tj1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        tj2.start();
//        tj3.start();


        //测试守护线程setDaemon
//        ThreadJoin td1 = new ThreadJoin();
////        ThreadJoin td2 = new ThreadJoin();
////        td1.setName("关羽");
////        td2.setName("张飞");
////        // 设置收获线程
////        td1.setDaemon(true);
////        td2.setDaemon(true);
////        td1.start();
////        td2.start();
////        Thread.currentThread().setName("刘备");
////        for (int x = 0; x < 5; x++) {
////            System.out.println(Thread.currentThread().getName() + ":" + x);
////        }
    }


}

class ThreadJoin extends Thread {
    @Override
    public void run() {
        for (int x = 0; x < 100; x++) {
            System.out.println(getName() + ":" + x);
        }
    }
}


class MyThread3 implements Runnable {

    public void run() {
        for (int x = 0; x < 200; x++) {
            System.out.println(Thread.currentThread().getName() + "-----" +x);
        }
    }
}


 class MyThread2 extends Thread {
    public MyThread2() {
    }
    public MyThread2(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int x = 0; x < 200; x++) {
            System.out.println(getName() + "---" + x);
        }
    }
}



