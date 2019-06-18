package fourthweek.demo0603;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class HomeWorkThread2 {
    public static void main(String[] args) throws InterruptedException {
        CallableThread1 callableThread1 = new CallableThread1();
        FutureTask futureTask1 = new FutureTask(callableThread1);
        Thread thread1 = new Thread(futureTask1);
        //开除经理
        thread1.start();
        thread1.join();

        //给各部门总监开会
        Thread1 thread4 = new Thread1();
        thread4.start();
        thread4.join();

        //陪VIP客户吃饭
        Thread2 thread5 = new Thread2();
        long start = System.currentTimeMillis();
        thread5.start();
        thread5.join();
        long end = System.currentTimeMillis();
        System.out.println("陪客户吃饭花费时间为："+ (end-start));


        //买礼物
        CallableThread2 callableThread2 = new CallableThread2();
        FutureTask futureTask2 = new FutureTask(callableThread2);
        Thread thread2 = new Thread(futureTask2);
        thread2.start();

        //陪老妈去医院
        CallableThread3 callableThread3 = new CallableThread3();
        FutureTask futureTask3 = new FutureTask(callableThread3);
        Thread thread3 = new Thread(futureTask3);
        thread3.start();


        RunnableThread1 runnableThread1 = new RunnableThread1();
        RunnableThread2 runnableThread2 = new RunnableThread2();
        Thread thread6 = new Thread(runnableThread1);
        Thread thread7 = new Thread(runnableThread2);

        //去机场接女儿
        thread6.start();

        //辅导儿子作业
        thread7.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}


//辅导儿子作业
class RunnableThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("辅导儿子作业");
    }
}

//去机场接女儿
class RunnableThread1 implements Runnable{
    @Override
    public void run() {
        System.out.println("去机场接女儿");
    }
}

//陪VIP客户吃饭
class Thread2 extends Thread{
    @Override
    public void run() {
        System.out.println("陪VIP客户吃饭!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


//给各部门总监开会
class Thread1 extends Thread{
    @Override
    public void run() {
        System.out.println("给各部门总监开会!");
    }
}

//开除经理
class CallableThread1 implements Callable<String>{
    @Override
    public String call() throws Exception {
        System.out.println("You are an unreliable manager! ");
        return "You are fired!";
    }
}


//买礼物
class CallableThread2 implements Callable<String>{
    @Override
    public String call() throws Exception {
        System.out.println("6Plus");
        return "6Plus";
    }
}


//陪老妈去医院
class CallableThread3 implements Callable<String>{
    @Override
    public String call() throws Exception {
        System.out.println("Go to the hospital with my mother");
        return "Go to the hospital with my mother";
    }
}
