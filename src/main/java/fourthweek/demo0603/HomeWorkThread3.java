package fourthweek.demo0603;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HomeWorkThread3 {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        threadA.setDaemon(true);
        threadA.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class ThreadA extends  Thread{
    @Override
    public void run() {
        ThreadB threadB = new ThreadB();
        Thread thread = new Thread(threadB);
        thread.start();

        int sum=0;
        for (int i=0 ; i<10000; i++){
            if (i%2 == 0){
                sum+=i;
            }
        }
        System.out.println("10000内所有偶数之和为："+ sum);
    }
}


class ThreadB implements Runnable{
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            Date time = calendar.getTime();
            String format = simpleDateFormat.format(time);
            System.out.println("当前系统时间"+ format);

            System.out.println("当前线程的名称为："+ Thread.currentThread());

        }
    }
}
