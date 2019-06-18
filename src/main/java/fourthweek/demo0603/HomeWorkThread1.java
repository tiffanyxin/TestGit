package fourthweek.demo0603;

import java.util.Random;

import static java.lang.Thread.yield;

public class HomeWorkThread1 {
    public static void main(String[] args) {
        final Random random = new Random();

        //第一种方式
        new Thread(){
            @Override
            public void run() {
                for (int i =0; i<10000; i++){
                    if (i%200 == 0){
                        yield();
                    }
                    int randomNum = random.nextInt(10);
                    System.out.println(randomNum);
                }
            }
        }.start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0; i<10000; i++){
                    if (i%200 == 0){
                        yield();
                    }
                    int randomNum = random.nextInt(26)+97;
                    System.out.println((char) randomNum);
                }
            }
        }).start();

    }
}
